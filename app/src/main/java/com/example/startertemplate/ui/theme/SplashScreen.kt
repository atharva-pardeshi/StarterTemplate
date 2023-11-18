package com.example.startertemplate.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.startertemplate.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(durationMillis: Long, onTimeout: () -> Unit) {
    LaunchedEffect(true) {
        delay(durationMillis)
        onTimeout()
    }

    // Your SplashScreen content goes here
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Splash Screen Image",
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    )
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    StarterTemplateTheme {
        SplashScreen(durationMillis = 2000) {
            // This block won't be executed in the preview
        }
    }
}