package com.example.localartisans2.screens.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.localartisans2.screens.app.navigation.navigationHomeScreen
import com.example.localartisans2.screens.HomeScreen

@Composable
fun LocalArtisan(){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ){
        navigationHomeScreen()
    }
}