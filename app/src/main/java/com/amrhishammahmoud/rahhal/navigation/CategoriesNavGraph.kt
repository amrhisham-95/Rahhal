package com.amrhishammahmoud.rahhal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amrhishammahmoud.rahhal.screensBottomNavigation.CategoriesPage

@Composable
fun CategoriesNavGraph() {

    val navCategoriesController = rememberNavController()

    NavHost(navController = navCategoriesController , startDestination = "categories_main") {

        composable("categories_main") {
            CategoriesPage(navCategoriesController)
        }

    }
}