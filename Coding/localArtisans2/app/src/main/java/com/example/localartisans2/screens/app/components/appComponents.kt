package com.example.localartisans2.screens.app.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.localartisans2.R
import com.example.localartisans2.UiTheme.ColorSecndary
import com.example.localartisans2.UiTheme.ComponentsShapes
import com.example.localartisans2.UiTheme.Primary


@Composable
fun NormalTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth().heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = androidx.compose.ui.graphics.Color.Black,
        textAlign = TextAlign.Center
    )
}


@Composable
fun HeadingTextComponentWithLogOut(value: String){
    Row(horizontalArrangement = Arrangement.SpaceBetween)
    {
        Image(
            painter = painterResource(id = R.drawable.local_artisans_logo1),
            contentDescription = null,
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
        )
        {
            logoutButton()
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Local Artisans",
                modifier = Modifier.fillMaxWidth().heightIn(),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                ),
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Center
            )
            Text(
                text = value,
                modifier = Modifier.fillMaxWidth().heightIn(),
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                ),
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Center
            )
        }
    }
}



@Composable
fun HeadingTextComponentWithoutLogout(value: String){
    Row(horizontalArrangement = Arrangement.SpaceBetween)
    {
        Image(
            painter = painterResource(id = R.drawable.local_artisans_logo1),
            contentDescription = null,
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
        )
        {

            Text(
                text = "Local Artisans",
                modifier = Modifier.fillMaxWidth().heightIn(),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                ),
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Center
            )
            Spacer (modifier = Modifier.height(20.dp))
            Text(
                text = value,
                modifier = Modifier.fillMaxWidth().heightIn(),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                ),
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Center
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myTextFireldContent(labelValue: String){
    val textValue = remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth().clip(ComponentsShapes.small),
        label = {Text(text = labelValue)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(labelValue: String){
    val password = remember {
        mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(ComponentsShapes.small),
        label = {Text(text = labelValue)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = ColorSecndary,
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password.value,
        onValueChange = {
            password.value = it
        }
    )
}

@Composable
fun CustomerClickableTextComponent(value: String, navController: NavHostController){
    val innitialText = "if you First Time user, please "
    val toRegister = "register"
    val andText = " \n If you forgot your Password, please click "
    val toResetPassword = "here "
    val andText2 = "to reset the Password"

    val annotatedString = buildAnnotatedString {
        append(innitialText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = "toRegister", annotation = toRegister)
            append(toRegister)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = "here", annotation = toResetPassword)
            append(toResetPassword)
        }
        append(andText2)
    }
    ClickableText(text = annotatedString, onClick = {offset ->
        //which part of the text was clicked
        annotatedString.getStringAnnotations(offset,offset).firstOrNull()?.also { span ->
            Log.d("ClickableTextComponent", "{$span")
            if (span.tag == toRegister){
                navController.navigate("CustomerSignUpScreen")
            }
            if (span.tag == toResetPassword){
                navController.navigate("ResetPasswordScreen")
            }
        }

    })
}

@Composable
fun ClickableTextResetPasswordArtisan(value: String , onTextSelected: (String) -> Unit){
    val innitianText = "If you forgot your Password, please click "
    val toResetPassword = " here"

    val annotatedString = buildAnnotatedString {
        append(innitianText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = "here", annotation = toResetPassword)
            append(toResetPassword)
        }
    }
    ClickableText(text = annotatedString, onClick = {offset ->
        annotatedString.getStringAnnotations(offset,offset).firstOrNull()?.also { span ->
            Log.d("ClickableTextComponent", "{$span")
            if (span.tag == toResetPassword){
                onTextSelected(span.item)
            }
        }
    })
}

@Composable
fun ButtonComponent(value: String){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)

    ){
        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp).background(
                brush = Brush.horizontalGradient(listOf(ColorSecndary, Primary)),
                RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center
        ){
            Text(text = value,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun logoutButton(){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .heightIn(14.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(20.dp).background(
                    brush = Brush.horizontalGradient(listOf(ColorSecndary, Primary)),
                    RoundedCornerShape(20.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Log Out",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}