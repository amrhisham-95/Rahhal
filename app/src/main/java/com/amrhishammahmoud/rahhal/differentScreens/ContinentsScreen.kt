package com.amrhishammahmoud.rahhal.differentScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.amrhishammahmoud.rahhal.R
import com.amrhishammahmoud.rahhal.navigation.HomeNavItem

@Composable
fun ContinentsScreenPage(navController: NavController){
    
    val continentsImages = listOf(
        R.drawable.africa_continent,
        R.drawable.europe_continent,
        R.drawable.asia_continent,
        R.drawable.north_america_continent,
        R.drawable.south_america_continent,
        R.drawable.oceania_continent,
        R.drawable.antarctica_continent
    )

    Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center){

        LazyVerticalGrid(  columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)) {

            items(continentsImages){ item ->
                Image(
                    painter = painterResource(id = item),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(12.dp))
                        .clickable{
                            navController.navigate(HomeNavItem.ContinentDetailsScreen.route)
                        }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContinentsScreenPagePreview(){
    ContinentsScreenPage(
        navController = TODO()
    )
}