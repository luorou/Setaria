package com.bye.ane.begonia

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    val navHostController = rememberNavController()
    MaterialTheme {
        AppNavGraph(navHostController)
    }
}