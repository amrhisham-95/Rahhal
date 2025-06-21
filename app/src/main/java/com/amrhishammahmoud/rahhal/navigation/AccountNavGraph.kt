package com.amrhishammahmoud.rahhal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amrhishammahmoud.rahhal.screensBottomNavigation.AccountPage

@Composable
fun AccountNavGraph() {

    val navAccountController = rememberNavController()

    NavHost(navController = navAccountController, startDestination = "account_main") {

        composable ("account_main"){
            AccountPage(navAccountController)
        }
    }
}