package com.example.startertemplet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.startertemplet.ui.theme.StarterTempletTheme

@Composable
fun LoginScreen() {
    StarterTempletTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "App Logo",
                    colorFilter = ColorFilter.tint(color = Color.Black)
                )

                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Login", fontSize = 24.sp, fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "or", fontSize = 18.sp, fontWeight = FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Signup", fontSize = 24.sp, fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
                MobileNumberEditText()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobileNumberEditText() {
    var mobileNumber by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        // Use BasicTextField for editable text input
        TextField(
            value = mobileNumber,
            onValueChange = { mobileNumber = it },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            textStyle = TextStyle.Default.copy(color = Color.Black), // Customize text color
            visualTransformation = VisualTransformation.None, // Show actual input (no transformation)
            leadingIcon = {
                Row {
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "+91")
                }
            },
            trailingIcon = {
                // You can use a trailing icon for additional functionality if needed
            },
            placeholder = {
                Text("Enter your mobile number")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .padding(10.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "By continuing, I agree to the ",
                        fontSize = 14.sp,
                    )
                    Text(
                        text = "Terms Of Use",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = " and ",
                        fontSize = 14.sp,
                    )
                    Text(
                        text = "Privacy Policy",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        // Display a button or perform any action based on the entered mobile number
        Button(
            onClick = {
                // Perform an action with the entered mobile number
                // For example, validate the number or navigate to the next screen
                // For now, just print the mobile number to the log
                println("Entered Mobile Number: ${mobileNumber.text}")
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
        ) {
            Text("Continue")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = "Having trouble logging in?",
                fontSize = 14.sp,
            )
            Text(
                text = " Get help",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Preview
@Composable
fun LoginPreview() {
    StarterTempletTheme {
        LoginScreen()
    }
}