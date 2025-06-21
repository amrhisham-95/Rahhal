package com.amrhishammahmoud.rahhal.screensBottomNavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun AccountPage(navController: NavController){

    Box(modifier = Modifier.fillMaxSize()){

        Text(text = "Account Page")

    }
}


@Preview(showBackground = true)
@Composable
fun AccountPagePreview(){
    AccountPage(
        navController = TODO()
    )
}