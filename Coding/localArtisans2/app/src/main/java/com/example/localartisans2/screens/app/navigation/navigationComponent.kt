package com.example.localartisans2.screens.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.localartisans2.screens.ArtisanLoginScreen
import com.example.localartisans2.screens.HomeScreen
import com.example.localartisans2.screens.ArtisanHomeScreen
import com.example.localartisans2.screens.CustomerHomeDashboardScreen
import com.example.localartisans2.screens.CustomerSignUpScreen
import com.example.localartisans2.screens.LoginScreenForCustomer
import com.example.localartisans2.screens.ResetPasswordScreen


@Composable
fun navigationHomeScreen (){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomeScreen"){
        composable(route = "HomeScreen"){
            HomeScreen(navController)
        }

        composable(route = "ArtisanLoginScreen"){
            ArtisanLoginScreen(navController)
        }

        composable(route = "loginScreenForCustomer"){
            LoginScreenForCustomer(navController)

        }

    }
}

@Composable
fun loginArtisanNavigation (){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomeScreen")
    {
        composable(route = "HomeScreen"){
            HomeScreen(navController)
        }
        composable(route = "ArtisansHomeScreen"){
            ArtisanHomeScreen(navController)
        }
    }

}


@Composable
fun loginCustomerNavigation (){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "loginScreenForCustomer")
    {
        composable(route = "loginScreenForCustomer"){
            LoginScreenForCustomer(navController)
        }
        composable(route = "CustomerHomeDashboardScreen"){
            CustomerHomeDashboardScreen(navController)
        }
        composable(route = "CustomerSignUpScreen"){
            CustomerSignUpScreen(navController)
        }
        composable(route = "ResetPasswordScreen"){
            ResetPasswordScreen(navController)
        }
    }
}


@Composable
fun navigationCustomerHomeScreen (){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "")
    {
        composable(route = "loginScreenForCustomer"){
            LoginScreenForCustomer(navController)
        }
    }
}