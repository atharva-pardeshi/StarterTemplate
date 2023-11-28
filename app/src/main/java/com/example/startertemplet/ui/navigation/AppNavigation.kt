package com.example.startertemplet.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.startertemplet.ui.HomeScreen
import com.example.startertemplet.ui.login.LoginScreen
import com.example.startertemplet.ui.login.OtpScreen

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