package com.example.localartisans2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.localartisans2.screens.app.components.ButtonComponent
import com.example.localartisans2.screens.app.components.HeadingTextComponentWithoutLogout
import com.example.localartisans2.screens.app.components.PasswordTextFieldComponent
import com.example.localartisans2.screens.app.components.myTextFireldContent

@Composable
fun CustomerSignUpScreen(navController: NavHostController) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp),

        )
    {
        Column(modifier = Modifier.fillMaxSize()) {
            HeadingTextComponentWithoutLogout(value = "Customer Registration Screen")
            Spacer(modifier = Modifier.height(40.dp))
            myTextFireldContent(labelValue = "First Name")
            myTextFireldContent(labelValue = "Last Name")
            myTextFireldContent(labelValue = "Email")
            Text(
                text = "Please enter a valid email address" +
                        "\n such as" +
                        " @gmail, @hotmail, @live.ie",
                color = Color.Gray,
                fontSize = 12.sp
            )

            //TODO Phone Number TextField
            myTextFireldContent(labelValue = "Phone number")
            Spacer(modifier = Modifier.height(20.dp))
            //REfactpr the PasswordTextFieldComponent
            PasswordTextFieldComponent(labelValue = "Password")
            //TODO Create Confirm Password TextField
            PasswordTextFieldComponent(labelValue = "Confirm Password")
            Spacer(modifier = Modifier.height(40.dp))
            //TODO add Component Register Button
            ButtonComponent(value = "Register")

            //TODO Record can`t not be created without every single validation.
        }
    }
}