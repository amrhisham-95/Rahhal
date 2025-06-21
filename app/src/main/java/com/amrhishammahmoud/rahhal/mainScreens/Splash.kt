package com.amrhishammahmoud.rahhal.mainScreens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.amrhishammahmoud.rahhal.R
import com.amrhishammahmoud.rahhal.viewModels.RoomViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun SplashPage(navController: NavController) {

    val coroutineScope = rememberCoroutineScope()
    val roomViewModel: RoomViewModel = hiltViewModel()
    val context = LocalContext.current

    LaunchedEffect(true) {
        delay(2500) // Splash screen delay


        coroutineScope.launch {
            val  userEntity = roomViewModel.loginSplash()
            val sharedPref = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
            val isLoggedIn = sharedPref.getBoolean("is_logged_in", false)

            if (userEntity != null && isLoggedIn) {
                Toast.makeText(context, "Welcoming", Toast.LENGTH_SHORT)
                    .show()

                navController.navigate("detailsProject"){
                    popUpTo("splash") { inclusive = true }
                }

            }else{
                navController.navigate("login") {
                    popUpTo("splash") { inclusive = true }
                }
            }
        }



    }

    Box(modifier = Modifier.fillMaxSize().navigationBarsPadding(), contentAlignment = Alignment.Center) {

        Image(
            painter = painterResource(id = R.drawable.splash_page),
            contentDescription = "My image",
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

    }
}


@Preview(showBackground = true)
@Composable
fun SplashPagePreview() {
    SplashPage(navController = rememberNavController())
}