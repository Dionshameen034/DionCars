package com.dion.dioncars.ui.theme.screens.LoginScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dion.dioncars.data.AuthViewModel
import com.dion.dioncars.navigation.ROUTE_HOME
import com.dion.dioncars.navigation.ROUTE_REGISTER
import com.dion.dioncars.ui.theme.screens.Screens


@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    Column (modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Text(text = "Login here",
            color = Color.Blue,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = email, onValueChange = {email = it},
            label = { Text(text = "Email")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = Color.Cyan,
                unfocusedLeadingIconColor = Color.Cyan,
                focusedLabelColor = Color.Cyan,
                unfocusedLabelColor = Color.Cyan,
                focusedContainerColor = Color.Black,
                unfocusedContainerColor = Color.Black,
                focusedIndicatorColor = Color.Cyan,
                unfocusedIndicatorColor = Color.Cyan,
                unfocusedPlaceholderColor = Color.Cyan
            ), leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = pass, onValueChange = {pass = it},
            label = { Text(text = "Password")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = Color.Cyan,
                unfocusedLeadingIconColor = Color.Cyan,
                focusedLabelColor = Color.Cyan,
                unfocusedLabelColor = Color.Cyan,
                focusedContainerColor = Color.Black,
                unfocusedContainerColor = Color.Black,
                focusedIndicatorColor = Color.Cyan,
                unfocusedIndicatorColor = Color.Cyan,
                unfocusedPlaceholderColor = Color.Cyan
            ), leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            visualTransformation = PasswordVisualTransformation( )
        )
        Spacer(modifier = Modifier.height(20.dp))
        val context= LocalContext.current.applicationContext
        val mylogin= AuthViewModel(navController, context )

        Button(onClick = {

            mylogin.login(email.text.trim(),pass.text.trim())
        }, colors = ButtonDefaults.buttonColors(Color.Cyan),
            contentPadding = PaddingValues(start = 60.dp, end = 60.dp, top = 8.dp, bottom = 8.dp),
            modifier = Modifier.padding(top = 18.dp)
                ) {
            Text(text ="Login")

        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_REGISTER)
        }, colors = ButtonDefaults.buttonColors(Color.Cyan),
            contentPadding = PaddingValues(start = 60.dp, end = 60.dp, top = 8.dp, bottom = 8.dp),
            modifier = Modifier.padding(top = 18.dp)
        ) {
            Text(text ="Register Instead")
        }
    }
        
    }




@Preview
@Composable
private fun LoginPrev() {
    LoginScreen(rememberNavController())

}

