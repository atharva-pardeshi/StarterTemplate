package com.example.startertemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.startertemplate.ui.theme.StarterTemplateTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarterTemplateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Display the SplashScreen for 2 seconds before navigating to the main content
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen(){
    Box {
        Text(text = "Welcome to Login function")
    }
}

@Preview
@Composable
fun LoginPreview(){
    StarterTemplateTheme {
        LoginScreen()
    }
}