package com.bye.ane.feature.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.bye.ane.feature.login.page.LoginPage
import com.bye.ane.feature.login.page.RegisterPage

@Composable
fun LoginPageRoute(navController: NavHostController) {
    LoginPage(modifier = Modifier)
}

@Composable
fun RegisterPageRoute(navController: NavHostController) {
    RegisterPage(modifier = Modifier)
}