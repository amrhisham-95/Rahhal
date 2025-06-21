package com.amrhishammahmoud.rahhal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amrhishammahmoud.rahhal.differentScreens.ContinentsDetailsScreenPage
import com.amrhishammahmoud.rahhal.differentScreens.ContinentsScreenPage
import com.amrhishammahmoud.rahhal.differentScreens.CountriesScreenPage
import com.amrhishammahmoud.rahhal.differentScreens.PopularScreenPage
import com.amrhishammahmoud.rahhal.differentScreens.WorldClocksScreenPage
import com.amrhishammahmoud.rahhal.screensBottomNavigation.HomePage

@Composable
fun HomeNavGraph() {

    val navHomeController = rememberNavController()


    NavHost(navController = navHomeController, startDestination = "home_main") {

        composable("home_main") {
            HomePage(navHomeController)
        }
        //الشاشات اللي جوا ال Home
        composable("continentsScreen") {
            ContinentsScreenPage(navHomeController)
        }

        composable("continentDetails") {
            ContinentsDetailsScreenPage(navHomeController)
        }

        composable("countriesScreen") {
            CountriesScreenPage(navHomeController)
        }
        composable("worldClocksScreen") {
            WorldClocksScreenPage(navHomeController)
        }
        composable("popularScreen") {
            PopularScreenPage(navHomeController)
        }
    }
}


