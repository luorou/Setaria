package com.bye.ane.feature.index

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.bye.ane.feature.index.page.IndexPage
import com.bye.ane.feature.index.page.WelcomePage


@Composable
fun WelcomePageRoute(navController: NavHostController) {
    WelcomePage(navController, modifier = Modifier)
}

@Composable
fun IndexPageRoute(navController: NavHostController) {
    IndexPage(navController, modifier = Modifier)
}