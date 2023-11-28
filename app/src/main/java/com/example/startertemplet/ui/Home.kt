package com.example.startertemplet.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.startertemplet.ui.theme.StarterTempletTheme

@Composable
fun HomeScreen(navController: NavController){
    Text(text = "Welcome to home screen")
}

@Preview
@Composable
fun HomeScreenPreview(){
    val navController = rememberNavController()
    StarterTempletTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(navController = navController)
        }
    }
}