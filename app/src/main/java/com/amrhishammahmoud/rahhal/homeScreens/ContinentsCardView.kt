package com.amrhishammahmoud.rahhal.homeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.amrhishammahmoud.rahhal.R
import com.amrhishammahmoud.rahhal.navigation.HomeNavItem
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ContinentsCardViewFun(navController: NavController,continentName: String , continentImage: Int) {
    Box(
        modifier = Modifier
            .height(77.dp)
            .width(303.dp), contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(continentImage),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxSize()
                .border(2.dp, Color(0xffD57817), shape = RoundedCornerShape(12.dp)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = continentName,
                modifier = Modifier.padding(start = 12.dp, end = 2.dp),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontSize = 24.sp,
                    brush = Brush.linearGradient(
                        colorStops = arrayOf(
                            0.00f to Color(0xFF5686B7), // 100% opacity
                            1.00f to Color(0xFF263B51), // 100% opacity
                        ),
                        start = Offset(
                            1000f * cos(Math.toRadians(90f.toDouble())).toFloat(),
                            1000f * sin(Math.toRadians(90f.toDouble())).toFloat()
                        ),
                        end = Offset(
                            0f, 0f
                        )
                    )
                )
            )


            IconButton(onClick = { navController.navigate(HomeNavItem.ContinentsScreen.route) }) {
                Image(
                    painter = painterResource(R.drawable.double_arrow),
                    contentDescription = "",
                    modifier = Modifier.size(36.dp)
                )
            }


        }

    }
}



@Preview(showBackground = true)
@Composable
fun ContinentsCardViewFunPreview() {
    ContinentsCardViewFun(
        continentName = TODO(),
        continentImage = TODO(),
        navController = TODO()
    )

}