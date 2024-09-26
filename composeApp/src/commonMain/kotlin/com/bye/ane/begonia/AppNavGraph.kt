package com.bye.ane.begonia

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bye.ane.feature.index.IndexPageRoute
import com.bye.ane.feature.index.WelcomePageRoute
import com.bye.ane.core.network.RoutersPath
import com.bye.ane.feature.login.LoginPageRoute

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = RoutersPath.Index.INDEX,
) {

    //
    NavHost(navController = navController, startDestination = startDestination) {
        composable(
            route = RoutersPath.Index.WELCOME,
        ) {
            WelcomePageRoute(navController)
        }
        //
        composable(
            route = RoutersPath.Index.INDEX,
        ) {
            IndexPageRoute(navController)
        }
        //
        composable(
            route = RoutersPath.Login.LOGIN,
        ) {
            LoginPageRoute(navController)
        }
        composable(
            route = RoutersPath.Login.REGISTER,
        ) {
            LoginPageRoute(navController)
        }
    }


}