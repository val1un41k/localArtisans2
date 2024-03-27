package com.example.localartisans2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

import com.example.localartisans2.screens.app.components.ButtonComponent
import com.example.localartisans2.screens.app.components.HeadingTextComponentWithLogOut

@Composable
fun ArtisanHomeScreen(navController: NavHostController) {
    Surface(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            HeadingTextComponentWithLogOut(value = "Artisan's Home Screen")
            Spacer(modifier = Modifier.height(40.dp))

            //TODO Create Component ArtisanPersonalDetailsButton
            ButtonComponent(value = "Update Personal and Business Details")
            Spacer(modifier = Modifier.height(40.dp))

            //TODO Create Component ArtisanProductCategoryProfileButton
            ButtonComponent(value = "Artisan`s Product Category Profile")
            Spacer(modifier = Modifier.height(40.dp))

            //TODO Create Component ArtisanProductItemsWithinCathegoryButton
            ButtonComponent(value = "Artisan`s Product Items Within a Cathegory")
            Spacer(modifier = Modifier.height(40.dp))

            //TODO Create Component ArtisanProductItemsWithinCathegoryButton
            ButtonComponent(value = "View Customer Request " +
                    "\n Send Notifications and Invoices")
            Spacer(modifier = Modifier.height(40.dp))

            //TODO Create Component ArtisanProductItemsWithinCathegoryButton
            ButtonComponent(value = "View Customer`s Feedback and Rating")
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}