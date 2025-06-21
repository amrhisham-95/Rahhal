package com.amrhishammahmoud.rahhal.screensBottomNavigation


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.amrhishammahmoud.rahhal.R
import com.amrhishammahmoud.rahhal.homeScreens.ContinentsCardViewFun
import com.amrhishammahmoud.rahhal.homeScreens.CountriesCardViewFun
import com.amrhishammahmoud.rahhal.homeScreens.PopularDestinationsCardViewFun
import com.amrhishammahmoud.rahhal.homeScreens.WorldClocksCardViewFun
import com.amrhishammahmoud.rahhal.viewModels.RoomViewModel
import kotlin.math.cos
import kotlin.math.sin
import androidx.compose.runtime.getValue // for by
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.amrhishammahmoud.rahhal.models.CountriesDataDetails
import com.amrhishammahmoud.rahhal.models.CountriesSummaryData
import com.amrhishammahmoud.rahhal.navigation.HomeNavItem


@Composable
fun HomePage(
    navController: NavController,   roomViewModel: RoomViewModel = hiltViewModel()
) {
    val fields = "name,flags,continents,capital,area,population,maps"

    val context = LocalContext.current
    var isLoadedContinents by remember { mutableStateOf(false) }
    var isLoadedCountriesData by remember { mutableStateOf(false) }
    var isLoadedCountriesList by remember { mutableStateOf(false) }
    var isLoadedCountriesPictures by remember { mutableStateOf(false) }


    val continentsList by roomViewModel.readAllDataContinents.observeAsState()

    val countriesData by roomViewModel.liveDataCountriesMutable.observeAsState()

    val countriesList by roomViewModel.readAllDataCountriesSummary.observeAsState()

    val countriesPicturesList by roomViewModel.readAllDataCountriesPictures.observeAsState()

    val famousList by roomViewModel.readAllDataFamous.observeAsState()
    var isLoadedFamous by remember { mutableStateOf(false) }

    val summaryList = remember(countriesData) {
        countriesData?.map { mapToSummaryData(it) } ?: emptyList()
    }

    LaunchedEffect(Unit) {
        if (continentsList.isNullOrEmpty()) {
            roomViewModel.getDataContinentsFromDateBase(context)
        }
        isLoadedContinents = true


        if(famousList.isNullOrEmpty()){
           roomViewModel.getDataFamousFromDateBase()
        }
        isLoadedFamous = true


        if (countriesData.isNullOrEmpty()) {
            roomViewModel.getDataRetrofitViewModelCountriesSummary(fields.trim())
        }

        if(countriesPicturesList.isNullOrEmpty()){
            roomViewModel.getDataCountriesPicturesFromDateBase()
        }

        isLoadedCountriesPictures = true
    }


    LaunchedEffect(countriesData) {
        isLoadedCountriesData = true

        roomViewModel.addCountriesSummaryDataViewModel(summaryList)

        isLoadedCountriesList = true
    }





    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp, top = 12.dp, bottom = 12.dp),
            Arrangement.Top,
            Alignment.Start
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Continents",
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.tajawal_700)),
                        fontSize = 16.sp,
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
                Text(
                    text = "See All",
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .alpha(0.6f).clickable {
                            navController.navigate(HomeNavItem.ContinentsScreen.route)
                        },
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.tajawal_700)),
                        fontSize = 14.sp,
                        color = Color(0xFF383639)
                    )
                )
            }

            Spacer(modifier = Modifier.padding(2.dp))

            if (isLoadedContinents) {
                LazyRow(
                    modifier = Modifier
                        .height(77.dp)
                        .fillMaxWidth()
                        .background(
                            Color.Transparent, RoundedCornerShape(
                                12.dp
                            )
                        ), contentPadding = PaddingValues(0.dp)
                ) {
                    if (continentsList.isNullOrEmpty()) {
                        item {
                            Text(text = "no data")
                        }
                    } else {
                        items(continentsList!!) { it ->
                            ContinentsCardViewFun(navController,it.nameContinent, it.mapBackgroundContinent)
                            Spacer(modifier = Modifier.padding(8.dp))

                        }
                    }
                }
            }
            Spacer(modifier = Modifier.padding(8.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Countries",
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.tajawal_700)),
                        fontSize = 16.sp,
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
                Text(
                    text = "See All",
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .alpha(0.6f).clickable {
                            navController.navigate(HomeNavItem.CountriesScreen.route)
                        },
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.tajawal_700)),
                        fontSize = 14.sp,
                        color = Color(0xFF383639)
                    )
                )
            }

            Spacer(modifier = Modifier.padding(2.dp))

            if (isLoadedCountriesList) {
                LazyRow(
                    modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth()
                        .background(
                            Color.Transparent, RoundedCornerShape(
                                12.dp
                            )
                        ), contentPadding = PaddingValues(0.dp)
                ) {
                    if (countriesData.isNullOrEmpty()) {
                        item {
                            Text(text = "no data")
                        }
                    } else {

                        items(summaryList) { it ->
                            CountriesCardViewFun(
                                it.countryName,
                                it.countryFlag,
                                it.countryContinent,
                                it.countryCapital
                            )
                            Spacer(modifier = Modifier.padding(6.dp))


                        }
                    }
                }
            }

            Spacer(modifier = Modifier.padding(8.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Popular Destinations",
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.tajawal_700)),
                        fontSize = 16.sp,
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
                Text(
                    text = "See All",
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .alpha(0.6f).clickable {
                            navController.navigate(HomeNavItem.PopularScreen.route)
                        },
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.tajawal_700)),
                        fontSize = 14.sp,
                        color = Color(0xFF383639)
                    )
                )
            }

            Spacer(modifier = Modifier.padding(2.dp))

            if (isLoadedFamous){
            LazyRow(
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth()
                    .background(
                        Color.Transparent, RoundedCornerShape(
                            12.dp
                        )
                    ), contentPadding = PaddingValues(0.dp)
            ) {

                if (famousList.isNullOrEmpty()) {
                    item {
                        Text(text = "no data")
                    }
                } else {
                    items(famousList!!) { it ->
                        PopularDestinationsCardViewFun(
                            it.famousCountry,
                            it.famousImage,
                            it.famousName,
                            it.famousCity
                        )
                        Spacer(modifier = Modifier.padding(6.dp))
                    }
                }
            }
            }


            Spacer(modifier = Modifier.padding(8.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "World Clocks",
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.tajawal_700)),
                        fontSize = 16.sp,
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
                Text(
                    text = "See All",
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .alpha(0.6f).clickable {
                            navController.navigate(HomeNavItem.WorldClocksScreen.route)
                        },
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.tajawal_700)),
                        fontSize = 14.sp,
                        color = Color(0xFF383639)
                    )
                )
            }

            Spacer(modifier = Modifier.padding(2.dp))

            val zones = listOf(
                "Africa/Cairo",
                "Asia/Riyadh",
                "Europe/Paris",
                "America/New_York",
                "Asia/Tokyo",
                "Europe/London",
                "Asia/Dubai"
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = 4.dp),
            ) {
                items(zones) { timeZoneId ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        WorldClocksCardViewFun(
                            timeZone = timeZoneId
                        )
                        Text(
                            text = timeZoneId.substringAfter("/"),
                            color = Color(0xFF263B51),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

        }

    }
}

// دالة لعمل مابينج لتحويل الداتا من السيرفر للداتا الكلاس اللي انا عايزه
fun mapToSummaryData(item: CountriesDataDetails): CountriesSummaryData {
    return CountriesSummaryData(
        countryName = item.name.common,
        countryFlag = item.flags.png,
        countryPopulation = item.population,
        countryArea = item.area,
        countryContinent = item.continents.firstOrNull() ?: "Unknown",
        countryCapital = item.capital.firstOrNull() ?: "Unknown",
        countryMap = item.maps.googleMaps
    )
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    HomePage(
        navController = TODO(),
        roomViewModel = TODO()
    )
}