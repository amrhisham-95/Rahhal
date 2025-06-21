package com.amrhishammahmoud.rahhal.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amrhishammahmoud.rahhal.R
import com.amrhishammahmoud.rahhal.mainScreens.LoginPage
import com.amrhishammahmoud.rahhal.mainScreens.ProjectDetailsPage
import com.amrhishammahmoud.rahhal.mainScreens.SignupPage
import com.amrhishammahmoud.rahhal.mainScreens.SplashPage


@Composable
fun NavMainActivity(){

    val navController = rememberNavController()


    NavHost(navController = navController , startDestination = "splash") {

        composable ("splash"){
            SplashPage(navController)
        }

        composable("login"){
            LoginPage(navController)
        }


        composable ("signup"){
            SignupPage(navController)
        }


        composable("detailsProject") {
            ProjectDetailsPage(navController)
        }

    }
}




