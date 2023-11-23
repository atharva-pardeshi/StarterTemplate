package com.example.startertemplet

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "LoginScreen"
    ){
        composable("LoginScreen"){
            LoginScreen(navController)
        }

        composable("OTPScreen"){
            OtpScreen(navController)
        }
    }
}