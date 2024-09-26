package com.bye.ane.feature.index.page

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import com.bye.ane.core.network.RoutersPath
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun WelcomePage(navController: NavHostController, modifier: Modifier) {

    val scope = rememberCoroutineScope()
    scope.launch {
        delay(1000)
        navController.navigate(RoutersPath.Index.INDEX) {
            popUpTo(RoutersPath.Index.WELCOME) {
                inclusive = true
            }
        }
    }



    Scaffold { innerPadding ->

    }
}