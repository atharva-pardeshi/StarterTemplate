package com.example.startertemplate

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.startertemplate.ui.theme.SplashScreen
import com.example.startertemplate.ui.theme.StarterTemplateTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarterTemplateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Display the SplashScreen for 2 seconds before navigating to the main content
                    SplashScreen(durationMillis = 2000) {
                        // Navigate to the main content (e.g., another composable)
                        startActivity(Intent(this@MainActivity, Login::class.java))
                        // Finish the current splash screen activity (optional)
                        finish()
                    }
                }
            }
        }
    }
}