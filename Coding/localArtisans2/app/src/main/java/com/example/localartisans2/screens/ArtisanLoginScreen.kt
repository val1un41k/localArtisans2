package com.example.localartisans2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.localartisans2.UiTheme.ColorSecndary
import com.example.localartisans2.UiTheme.ComponentsShapes
import com.example.localartisans2.UiTheme.Primary
import com.example.localartisans2.screens.app.components.ClickableTextResetPasswordArtisan
import com.example.localartisans2.screens.app.components.HeadingTextComponentWithoutLogout
import com.example.localartisans2.screens.app.data.ArtisanLoginViewModel
import com.example.localartisans2.screens.app.navigation.loginArtisanNavigation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtisanLoginScreen(navController: NavHostController,
                       artisanLoginViewModel: ArtisanLoginViewModel? = null) {
    loginArtisanNavigation()
    val artisanLoginViewModel = viewModel(modelClass = ArtisanLoginViewModel :: class.java)

    val artisanLoginUiState = artisanLoginViewModel?.artisanLoginUiState
    val isError = artisanLoginUiState?.loginError !=null
    val context = LocalContext.current


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp),
    ){



        Column(
            modifier = Modifier.fillMaxSize()
        ){
            HeadingTextComponentWithoutLogout(value = "Artisan Login Screen")
            Spacer(modifier = Modifier.height(40.dp))

            val artisanLoginName = remember {mutableStateOf(artisanLoginUiState?.artisanEmail?:"")}
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(ComponentsShapes.small),
                value =artisanLoginName.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = ColorSecndary,
                    focusedBorderColor = Primary,
                    focusedLabelColor = Primary,
                    cursorColor = Primary,
                ),
                onValueChange = {artisanLoginName.value = it},

                //TODO Validation of artisanLoginName:
                //

                keyboardOptions = KeyboardOptions.Default,
                label = {
                    Text(text = "User Name (email)")
                },
            )
            artisanLoginViewModel?.onArtisanUserNameChanged(artisanLoginName.value)

            Spacer(modifier = Modifier.height(40.dp))

            // enter artisan password to login
            var artisanLoginPassword = remember { mutableStateOf(artisanLoginUiState?.artisanPassword?:"")}
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(ComponentsShapes.small),
                label = {Text(text = "Password")},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = ColorSecndary,
                    focusedBorderColor = Primary,
                    focusedLabelColor = Primary,
                    cursorColor = Primary,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                value = artisanLoginPassword.value,
                onValueChange = {
                    artisanLoginPassword.value = it
                }
            )
            artisanLoginViewModel?.onArtisanPasswordChanged(artisanLoginPassword.value)

            if (isError){
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = artisanLoginUiState?.loginError?:"unknown Error",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }

            // button login, check validations and navigate to the artisanHome screen
            Button(
                onClick = { artisanLoginViewModel?.artisanLoginUser(context)
                          },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(48.dp),
                contentPadding = PaddingValues(),
                colors = ButtonDefaults.buttonColors(Color.Transparent)

            ){
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(48.dp)
                    .background(
                        brush = Brush.horizontalGradient(listOf(ColorSecndary, Primary)),
                        RoundedCornerShape(50.dp)
                    ),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "Sign In",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold)
                }
                //if creating user is sucessful - navigate to the artisanHome screen
                if (artisanLoginUiState?.isSuccessLogin == true){
                    navController.navigate("ArtisanHomeScreen")
                }

            }

            Spacer(modifier = Modifier.height(40.dp))

            //using the ClickableTextResetPasswordArtisan will lead to the reset password screen

            ClickableTextResetPasswordArtisan(value = "reset Password", onTextSelected = {
            navController.navigate("ArtisanResetPasswordScreen") })


        }
    }
}
