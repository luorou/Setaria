package com.bye.ane.begonia

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import setaria.composeapp.generated.resources.Res
import setaria.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    val navHostController = rememberNavController()
    MaterialTheme {
        AppNavGraph(navHostController, onFinish = {})
    }
}