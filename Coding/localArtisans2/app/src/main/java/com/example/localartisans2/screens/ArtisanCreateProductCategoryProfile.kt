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
import com.example.localartisans2.screens.app.components.ButtonComponent
import com.example.localartisans2.screens.app.components.HeadingTextComponentWithLogOut
import com.example.localartisans2.screens.app.components.myTextFireldContent

@Composable
fun ArtisanCreateProductCategoryProfile() {
    Surface(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            HeadingTextComponentWithLogOut(value = "Artisan`s Product Category Profile")
            myTextFireldContent(labelValue = "Artisan`s Name & Surname")
            Spacer(modifier = Modifier.height(20.dp))
            Text("Select Product Category")
            Spacer(modifier = Modifier.height(20.dp))
            ButtonComponent(value = "Create Category Record")

            Spacer(modifier = Modifier.height(35.dp))
            ButtonComponent(value = "Next product Category")
            Spacer(modifier = Modifier.height(35.dp))
            ButtonComponent(value = "Back to Dashboard")
        }

    }
}