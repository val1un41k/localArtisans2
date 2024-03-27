package com.example.localartisans2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.localartisans2.R
import com.example.localartisans2.UiTheme.ColorSecndary
import com.example.localartisans2.UiTheme.ComponentsShapes
import com.example.localartisans2.UiTheme.Primary
import com.example.localartisans2.screens.app.components.ButtonComponent
import com.example.localartisans2.screens.app.components.HeadingTextComponentWithLogOut


@Composable
fun UpdateArtisansPersonalDetails() {
    Surface(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
        ) {
            HeadingTextComponentWithLogOut(value = "Update Artisan's Personal / Business Details")
            //TODO Create Component
            Row() {
                Column() {
                    ModifyArtisanDetailsTextField(labelValue = "Artisan's Name")
                    ModifyArtisanDetailsTextField(labelValue = "Artisan's Surname")
                }
                Column(){
                    Spacer(modifier = Modifier.height(10.dp))
                    ButtonComponent(value = "Update")
                }

            }

            Spacer(modifier = Modifier.height(5.dp))
            Row() {
                Column() {
                    ModifyArtisanDetailsTextField(labelValue = "Artisan mobile number")
                    Spacer(modifier = Modifier.height(5.dp))
                }
                Column() {
                    Spacer(modifier = Modifier.height(10.dp))
                    ButtonComponent(value = "Update")

                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Artisan Photo",
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                ),
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Center
            )

            ButtonComponent(value = "Upload")
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Business Venue Address",
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                ),
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Center
            )
            Row(){
                Column(){
                    Spacer(modifier = Modifier.height(5.dp))
                    ModifyArtisanDetailsTextField(labelValue = "Street Address")
                    Spacer(modifier = Modifier.height(5.dp))
                    ModifyArtisanDetailsTextField(labelValue = "Logitude")
                    Spacer(modifier = Modifier.height(5.dp))
                    ModifyArtisanDetailsTextField(labelValue = "Latitude")

                }
                Column(){
                    Spacer(modifier = Modifier.height(10.dp))
                    ButtonComponent(value = "Update")
                }
            }

            Spacer(modifier = Modifier.height(5.dp))
            //TODO Create Component ArtisanUpdateCancelButton
            ButtonComponent(value = "Cancel")

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModifyArtisanDetailsTextField(labelValue: String){
    val textValue = remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier.clip(ComponentsShapes.small),
        label = {Text(text = labelValue)},
        colors = outlinedTextFieldColors(
            containerColor = ColorSecndary,
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {textValue.value = it},
    )
}