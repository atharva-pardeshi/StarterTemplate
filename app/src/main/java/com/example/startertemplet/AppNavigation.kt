package com.example.startertemplet

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.startertemplet.ui.viewModel.LoginViewModel

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

        composable("HomeScreen"){
            HomeScreen(navController)
        }
    }
}