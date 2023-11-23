@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.startertemplet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.startertemplet.ui.theme.StarterTempletTheme

@Composable
fun OtpScreen(navController: NavController) {

    val mobileNumber = remember { "8847733712" }

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
        OtpTextField()
    }
}

@Composable
fun OtpTextField(){

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        OutlinedTextField(value = "1", onValueChange ={})
        OutlinedTextField(value ="2", onValueChange ={})
        OutlinedTextField(value ="3", onValueChange ={})
        OutlinedTextField(value ="4", onValueChange ={})
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