package com.amrhishammahmoud.rahhal.homeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.amrhishammahmoud.rahhal.R
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CountriesCardViewFun(
    countryName: String,
    countryImage: String,
    continentCountry: String,
    capitalCountry: String
) {
    Box(
        modifier = Modifier
            .height(140.dp)
            .width(140.dp).background(color = Color.Transparent), contentAlignment = Alignment.Center
    ) {

        AsyncImage(
            model = countryImage,
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .background(color= Color.Transparent)
                .clip(RoundedCornerShape(12.dp)),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {


                Column(
                    modifier = Modifier.fillMaxWidth().padding(2.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.End
                ) {
                    IconButton(onClick = { /*TODO*/ },modifier = Modifier.size(24.dp)) {
                        Image(
                            painter = painterResource(R.drawable.love_icon),
                            contentDescription = "",
                            modifier = Modifier.size(18.dp),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop
                        )
                    }

                    IconButton(onClick = { /*TODO*/ },modifier = Modifier.size(24.dp)) {
                        Image(
                            painter = painterResource(R.drawable.arrow_icon_more),
                            contentDescription = "",
                            modifier = Modifier.size(18.dp).alpha(0.8f),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop
                        )
                    }


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(start = 4.dp, end = 4.dp, bottom = 4.dp)
                    .background(
                        Color(0xFF676767).copy(alpha = 0.8f),
                        shape = RoundedCornerShape(
                            topStart = 4.dp,
                            topEnd = 4.dp,
                            bottomEnd = 12.dp,
                            bottomStart = 12.dp
                        )
                    ), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = countryName,
                        modifier = Modifier.padding(start = 2.dp, end = 2.dp, top = 2.dp),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            fontSize = 10.sp,
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

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 4.dp, end = 4.dp)
                            .height(40.dp), verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.continents_icon), // أو استخدم painterResource(R.drawable.your_icon)
                            contentDescription = "Favorite Icon",
                            modifier = Modifier.size(12.dp),
                            tint = Color(0xffD57817)
                            )

                        Spacer(modifier = Modifier.padding(1.dp))

                        Text(
                            text = continentCountry,
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                fontSize = 8.sp,
                                color = Color.White
                            )
                        )

                        Spacer(modifier = Modifier.padding(4.dp))

                        Icon(
                            painter = painterResource(R.drawable.capital_icon),
                            contentDescription = "",
                            tint = Color(0xffD57817),
                            modifier = Modifier.size(10.dp)
                        )

                        Spacer(modifier = Modifier.padding(1.dp))

                        Text(
                            text = capitalCountry,
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                fontSize = 8.sp,
                                color = Color.White
                            )
                        )

                        Spacer(modifier = Modifier.padding(4.dp))

                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun CountriesCardViewFunPreview() {
    CountriesCardViewFun(
        countryName = TODO(),
        countryImage = TODO(),
        continentCountry = TODO(),
        capitalCountry = TODO()
    )

}