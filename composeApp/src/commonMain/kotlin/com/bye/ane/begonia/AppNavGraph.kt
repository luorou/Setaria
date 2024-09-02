package com.bye.ane.begonia

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bye.ane.core.index.IndexPageRoute
import com.bye.ane.core.network.RoutersPath

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = RoutersPath.Index.INDEX,
    onFinish: () -> Unit = { }
) {

    //
    NavHost(navController = navController, startDestination = startDestination) {
        composable(
            route = RoutersPath.Index.INDEX,
        ) {
            IndexPageRoute(onBackClick = onFinish)
        }
        //

    }


}