package com.amrhishammahmoud.rahhal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amrhishammahmoud.rahhal.screensBottomNavigation.FavoritePage

@Composable
fun FavoriteNavGraph() {

    val navFavoriteController = rememberNavController()

    NavHost(navController = navFavoriteController, startDestination = "favorite_main") {
        composable("favorite_main") {
            FavoritePage(navFavoriteController)
        }

    }
}