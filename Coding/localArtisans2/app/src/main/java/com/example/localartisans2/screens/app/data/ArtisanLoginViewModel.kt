package com.example.localartisans2.screens.app.data

/*Change the login to BOTH Cusotmer and Artisan
//Logic related to what to lead will be on side of screen
//Not on side of firebase:
//Screen artisan -> login -> checking user -> if user is artisan -> go to artisan screen
Screen Artisan -> login -> checking user -> if user is customer -> back to check user type
"User artisan with such username and password is not exist"
*/


import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

class ArtisanLoginViewModel
    (private val repository: AuthRepository = AuthRepository()
            ): ViewModel() {
    val currentUser = repository.currentUser

    val hasUser: Boolean
        get() = repository.hasUser()

    var artisanLoginUiState by mutableStateOf(ArtisanLoginUiState())
        private set

    fun onArtisanUserNameChanged(artisanUserName: String) {
        artisanLoginUiState = artisanLoginUiState.copy(artisanEmail = artisanUserName)
    }

    fun onArtisanPasswordChanged(artisanPassword: String) {
        artisanLoginUiState = artisanLoginUiState.copy(artisanPassword = artisanPassword)
    }

    fun onArtisanSignUpEmailChanged(artisanEmailSignUp: String) {
        artisanLoginUiState = artisanLoginUiState.copy(artisanEmailSignUp = artisanEmailSignUp)
    }

    fun onArtisanSignUpPasswordChanged(artisanPasswordSignUp: String) {
        artisanLoginUiState =
            artisanLoginUiState.copy(artisanPasswordSignUp = artisanPasswordSignUp)
    }

    fun onArtisanConfirmPasswordChanged(artisanConfirmPassword: String) {
        artisanLoginUiState =
            artisanLoginUiState.copy(artisanConfirmPassword = artisanConfirmPassword)
    }

    //check if login validate
    private fun validateLoginForm() =
        artisanLoginUiState.artisanEmail.isNotBlank() && artisanLoginUiState.artisanPassword.isNotBlank()

    private fun validateSignUpForm() =
        artisanLoginUiState.artisanEmailSignUp.isNotBlank()
                && artisanLoginUiState.artisanPasswordSignUp.isNotBlank()
                && artisanLoginUiState.artisanConfirmPassword.isNotBlank()

    //creating artisan user
    fun artisanCreateUser(context: Context) = viewModelScope.launch {
        try {
            if (!validateSignUpForm()) {
                throw IllegalArgumentException("Email and Password can not be empty")
            }
            artisanLoginUiState = artisanLoginUiState.copy(isLoading = true)
            if (artisanLoginUiState.artisanPasswordSignUp !=
                artisanLoginUiState.artisanConfirmPassword) {
                throw IllegalArgumentException("Password do not match")
            }

            artisanLoginUiState = artisanLoginUiState.copy(artisanSignUpError = null)

            repository.createUser(
                artisanLoginUiState.artisanEmailSignUp,
                artisanLoginUiState.artisanPasswordSignUp
            ) { isSuccessful ->
                if (isSuccessful) {
                    Toast.makeText(
                        context,
                        "User created successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    artisanLoginUiState = artisanLoginUiState.copy(isSuccessLogin = true)

                } else {
                    Toast.makeText(
                        context,
                        "User creation failed",
                        Toast.LENGTH_SHORT
                    ).show()
                    artisanLoginUiState = artisanLoginUiState.copy(isSuccessLogin = false)
                }
            }
        } catch (e: Exception) {
            artisanLoginUiState = artisanLoginUiState.copy(artisanSignUpError = e.localizedMessage)
            e.printStackTrace()
        } finally {
            artisanLoginUiState = artisanLoginUiState.copy(isLoading = false)

        }
    }

    @SuppressLint("SuspiciousIndentation")
    fun artisanLoginUser(context: Context) = viewModelScope.launch{
        try{
            if (!validateLoginForm()){
                throw IllegalArgumentException("Email and Password can not be empty")
            }
            artisanLoginUiState = artisanLoginUiState.copy(isLoading = true)

            artisanLoginUiState = artisanLoginUiState.copy(loginError = null)

            repository.toLogin(
                artisanLoginUiState.artisanEmail,
                artisanLoginUiState.artisanPassword
            ){isSuccessful ->
                if (isSuccessful){
                    Toast.makeText(
                        context,
                        "Login successful",
                        Toast.LENGTH_SHORT
                    ).show()
                    artisanLoginUiState = artisanLoginUiState.copy(isSuccessLogin = true)
                }else{
                    Toast.makeText(
                        context,
                        "Login failed",
                        Toast.LENGTH_SHORT
                    ).show()
                    artisanLoginUiState = artisanLoginUiState.copy(isSuccessLogin = false)

            }
            }
        }
        catch (e:Exception){
        artisanLoginUiState = artisanLoginUiState.copy(loginError = e.localizedMessage)
            e.printStackTrace()
        }
        finally {
            artisanLoginUiState = artisanLoginUiState.copy(isLoading = false)
        }
    }

    fun signOut() {
        repository.signOut()
    }
}


data class ArtisanLoginUiState(
    val artisanEmail: String = "",
    val artisanPassword: String = "",
    val artisanPasswordSignUp: String = "",
    val artisanEmailSignUp: String = "",
    val artisanConfirmPassword: String = "",
    val isLoading: Boolean = false,
    val isSuccessLogin: Boolean = false,
    val artisanSignUpError: String? = null,
    val loginError: String? = null
)