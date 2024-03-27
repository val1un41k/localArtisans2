package com.example.localartisans2.screens.app.data



import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class customerLoginViewModel
    (private val repository: AuthRepository = AuthRepository()
): ViewModel() {
    val currentUser = repository.currentUser
    val hasUser = repository.hasUser()
    var customerLoginUiState by mutableStateOf(CustomerLoginUiState())
        private set

    fun onCustomerUserNameChanged(customerUserEmail: String) {
        customerLoginUiState = customerLoginUiState.copy(customerUserEmail = customerUserEmail)
    }

    fun onCustomerPasswordChanged(customerPassword: String) {
        customerLoginUiState = customerLoginUiState.copy(customerPassword= customerPassword)
    }

    fun onCustomerSignUpEmailChanged(customerEmailSignUp: String) {
       customerLoginUiState = customerLoginUiState.copy(customerUserEmailSignUp = customerEmailSignUp)
    }

    fun onCustomerSignUpPasswordChanged(customerPasswordSignUp: String) {
        customerLoginUiState =
            customerLoginUiState.copy(customerPasswordSignUp = customerPasswordSignUp)
    }

    fun onCustomerConfirmPasswordChanged(customerConfirmPassword: String) {
        customerLoginUiState =
            customerLoginUiState.copy(customerConfirmPassword = customerConfirmPassword)
    }

    //check if login validate
    private fun validateLoginForm() =
        customerLoginUiState.customerUserEmail.isNotBlank() && customerLoginUiState.customerPassword.isNotBlank()

    private fun validateSignUpForm() =
        customerLoginUiState.customerUserEmail.isNotBlank()
                && customerLoginUiState.customerPasswordSignUp.isNotBlank()
                && customerLoginUiState.customerConfirmPassword.isNotBlank()

    //creating artisan user
    fun onCustomerCreateUser(context: Context) = viewModelScope.launch {
        try {
            if (!validateSignUpForm()) {
                throw IllegalArgumentException("Email and Password can not be empty")
            }
            customerLoginUiState = customerLoginUiState.copy(isLoading = true)
            if (customerLoginUiState.customerPasswordSignUp != customerLoginUiState.customerConfirmPassword) {
                throw IllegalArgumentException("Passwords do not match")
            }

            customerLoginUiState = customerLoginUiState.copy(customerSignUpError = null)

            repository.createUser(
                customerLoginUiState.customerUserEmailSignUp,
                customerLoginUiState.customerPasswordSignUp
            ) { isSuccessful ->
                if (isSuccessful) {
                    Toast.makeText(
                        context,
                        "User created successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    customerLoginUiState = customerLoginUiState.copy(isSuccessLogin = true)

                } else {
                    Toast.makeText(
                        context,
                        "User creation failed",
                        Toast.LENGTH_SHORT
                    ).show()
                    customerLoginUiState = customerLoginUiState.copy(isSuccessLogin = false)
                }
            }
        } catch (e: Exception) {
            customerLoginUiState = customerLoginUiState.copy(customerSignUpError = e.localizedMessage)
            e.printStackTrace()
        } finally {
            customerLoginUiState = customerLoginUiState.copy(isLoading = false)

        }
    }

    @SuppressLint("SuspiciousIndentation")
    fun onCusotmerLoginUser(context: Context) = viewModelScope.launch{
        try{
            if (!validateLoginForm()){
                throw IllegalArgumentException("Email and Password can not be empty")
            }
            customerLoginUiState = customerLoginUiState.copy(isLoading = true)

            customerLoginUiState = customerLoginUiState.copy(customerLoginError = null)

            repository.toLogin(
                customerLoginUiState.customerUserEmail,
                customerLoginUiState.customerPassword
            ){isSuccessful ->
                if (isSuccessful){
                    Toast.makeText(
                        context,
                        "Login successful",
                        Toast.LENGTH_SHORT
                    ).show()
                    customerLoginUiState = customerLoginUiState.copy(isSuccessLogin = true)
                }else{
                    Toast.makeText(
                        context,
                        "Login failed",
                        Toast.LENGTH_SHORT
                    ).show()
                    customerLoginUiState = customerLoginUiState.copy(isSuccessLogin = false)

                }
            }
        }
        catch (e:Exception){
            customerLoginUiState = customerLoginUiState.copy(customerLoginError = e.localizedMessage)
            e.printStackTrace()
        }
        finally {
            customerLoginUiState = customerLoginUiState.copy(isLoading = false)
        }
    }
    fun signOut() {
        repository.signOut()
    }
}

data class CustomerLoginUiState(
    val customerUserEmail: String = "",
    val customerPassword: String = "",
    val customerPasswordSignUp: String = "",
    val customerUserEmailSignUp: String = "",
    val customerConfirmPassword: String ="",
    val isLoading: Boolean = false,
    val isSuccessLogin: Boolean = false,
    val customerSignUpError: String? = null,
    val customerLoginError: String? = null
)

