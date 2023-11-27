@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.startertemplet

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.startertemplet.ui.theme.StarterTempletTheme
import kotlinx.coroutines.delay

@Composable
fun OtpScreen(navController: NavController) {

    val mobileNumber by remember { mutableStateOf("8847733712") }
    var remainingTime by remember { mutableLongStateOf(60) }
    var buttonVisibility by remember { mutableStateOf(false) }
    var buttonText by remember { mutableStateOf("Resend")}
    var otpCode by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        while (remainingTime > 0) {
            delay(1000)
            remainingTime--
            buttonText = "Continue"
        }
        buttonText = "Resend"
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Icon(
            painter = painterResource(id = R.drawable.left_arrow_icon),
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
                .clickable {
                    navController.popBackStack()
                },
            contentDescription = "Back Button",
        )

        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Verify with OTP", fontSize = 24.sp, fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Sent via SMS to $mobileNumber", fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(50.dp))
        BasicTextField(
            value = otpCode, onValueChange = { newValue ->
                if (newValue.length <= 4) {
                    otpCode = newValue
                }

                buttonVisibility = newValue.length == 4
            }, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                for (index in 0 until 4) {
                    val number = when {
                        index >= otpCode.length -> ""
                        else -> otpCode[index].toString()
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = number,
                            style = MaterialTheme.typography.titleLarge,
                        )

                        Box(
                            modifier = Modifier
                                .width(40.dp)
                                .height(2.dp)
                                .background(Color.Black)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(50.dp))
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "Trying to auto-fill OTP ", fontSize = 14.sp
            )
            Text(
                text = "$remainingTime", fontSize = 18.sp, fontWeight = FontWeight.Bold
            )
            Text(
                text = " Sec", fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row{
            Text(
                text = "Having trouble logging in?",
                fontSize = 14.sp,
            )
            Text(
                text = " Get help", fontSize = 16.sp, fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = { navController.navigate("HomeScreen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp)
                .alpha(if (buttonVisibility) 1f else 0f),
        ) {
            Text(
                text = buttonText, fontSize = 16.sp, fontWeight = FontWeight.Bold
            )
        }
    }
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