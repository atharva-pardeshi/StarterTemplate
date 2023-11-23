package com.example.startertemplet

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
fun OtpScreen(navController: NavController) {
    Text(text = "hello")
}

@Preview
@Composable
fun OtpScreenPreview() {
    val navController = rememberNavController()
    StarterTempletTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            OtpScreen(navController = navController)
        }
    }
}