package com.amrhishammahmoud.rahhal.navigation

import com.amrhishammahmoud.rahhal.R

sealed class HomeNavItem(val route: String) {
    object ContinentsScreen : HomeNavItem("continentsScreen")
    object ContinentDetailsScreen : HomeNavItem("continentDetails")
    object CountriesScreen : HomeNavItem("countriesScreen")
    object WorldClocksScreen : HomeNavItem("worldClocksScreen")
    object PopularScreen : HomeNavItem("popularScreen")
}

sealed class BottomNavItem(val route: String, val icon: Int, val label: String) {
    object Home : BottomNavItem("home", R.drawable.home_icon, "Home")
    object Categories : BottomNavItem("categories", R.drawable.categories_icon, "Categories")
    object Favorite : BottomNavItem("favorite", R.drawable.cloud_icon, "Weather")
    object Account : BottomNavItem("account", R.drawable.account_icon, "Account")
}

val bottomNavItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.Categories,
    BottomNavItem.Favorite,
    BottomNavItem.Account
)
