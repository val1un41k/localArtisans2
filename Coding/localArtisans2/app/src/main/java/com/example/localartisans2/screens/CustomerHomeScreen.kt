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
import androidx.navigation.NavHostController

import com.example.localartisans2.screens.app.components.HeadingTextComponentWithLogOut

@Composable
fun CustomerHomeDashboardScreen(navController: NavHostController) {
    Surface(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            HeadingTextComponentWithLogOut(value = "Customer Home Dashboard Screen")
            Spacer(modifier = Modifier.height(80.dp))
            //TODO put space window with google map
            Text("Google Map")
            Spacer(modifier = Modifier.height(80.dp))


        }
    }

}