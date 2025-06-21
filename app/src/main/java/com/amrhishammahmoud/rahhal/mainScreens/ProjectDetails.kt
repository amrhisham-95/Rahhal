package com.amrhishammahmoud.rahhal.mainScreens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.amrhishammahmoud.rahhal.R
import com.amrhishammahmoud.rahhal.navigation.BottomNavItem
import com.amrhishammahmoud.rahhal.navigation.bottomNavItems
import com.amrhishammahmoud.rahhal.screensBottomNavigation.AccountPage
import com.amrhishammahmoud.rahhal.screensBottomNavigation.CategoriesPage
import com.amrhishammahmoud.rahhal.screensBottomNavigation.FavoritePage
import com.amrhishammahmoud.rahhal.screensBottomNavigation.HomePage
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.amrhishammahmoud.rahhal.differentScreens.ContinentsScreenPage
import com.amrhishammahmoud.rahhal.differentScreens.CountriesScreenPage
import com.amrhishammahmoud.rahhal.differentScreens.PopularScreenPage
import com.amrhishammahmoud.rahhal.differentScreens.WorldClocksScreenPage
import com.amrhishammahmoud.rahhal.navigation.AccountNavGraph
import com.amrhishammahmoud.rahhal.navigation.CategoriesNavGraph
import com.amrhishammahmoud.rahhal.navigation.FavoriteNavGraph
import com.amrhishammahmoud.rahhal.navigation.HomeNavGraph
import com.amrhishammahmoud.rahhal.viewModels.RoomViewModel
import kotlin.math.cos
import kotlin.math.sin

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectDetailsPage(navController: NavController) {

    val navControllerDetails = rememberNavController()
    var menuExpanded by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    val roomViewModel: RoomViewModel = hiltViewModel()

    val context = LocalContext.current


    Scaffold(
        topBar = {
            Box(
                modifier = Modifier.height(72.dp)
                    .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding())
                    .padding(horizontal = 8.dp)
                ,
                contentAlignment = Alignment.Center
            ) {
                CenterAlignedTopAppBar(
                    title = {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(color = Color.White)) {
                                        append("Ra")
                                    }
                                    withStyle(style = SpanStyle(color = Color(0xFF985005))) {
                                        append("hh")
                                    }
                                    withStyle(style = SpanStyle(color = Color.White)) {
                                        append("al")
                                    }
                                },
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    },
                    modifier = Modifier
                        .height(64.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            brush = Brush.linearGradient(
                                colorStops = arrayOf(
                                    0.24f to Color(0xFF5686B7), // 100% opacity
                                    0.36f to Color(0xFA406488), // ~98% opacity (FA = 98% in hex)
                                    0.60f to Color(0xF5263C51)  // ~96% opacity (F5 = 96% in hex)
                                ),
                                start = Offset(
                                    1000f * cos(Math.toRadians(310f.toDouble())).toFloat(),
                                    1000f * sin(Math.toRadians(310f.toDouble())).toFloat()
                                ),
                                end = Offset(
                                    0f, 0f
                                )

                            )
                        ),
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(R.drawable.menu_icon),
                                contentDescription = "Menu",
                                tint = Color.White
                            )
                        }
                    }, colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = Color.White
                    ),
                    actions = {

                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color.White
                            )
                        }

                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "Favorite",
                                tint = Color.White
                            )
                        }


                        IconButton(onClick = { menuExpanded = true }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "More options",
                                tint = Color.White

                            )
                        }

                        DropdownMenu(
                            expanded = menuExpanded,
                            onDismissRequest = { menuExpanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Logout") },
                                onClick = {
                                    menuExpanded = false
                                    // Handle logout click

                                    val sharedPref =
                                        context.getSharedPreferences(
                                            "user_prefs",
                                            Context.MODE_PRIVATE
                                        )
                                    sharedPref.edit().clear().apply()
                                    val isLoggedIn = sharedPref.edit().putBoolean("is_logged_in", false)

                                    navController.navigate("login") {
                                        popUpTo("details") { inclusive = true }
                                    }
                                }
                            )
                        }
                    }, windowInsets = WindowInsets(0.dp)

                )
            }
        },
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .height(106.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .background(
                        brush = Brush.linearGradient(
                            colorStops = arrayOf(
                                0.24f to Color(0xFF5686B7), // 100% opacity
                                0.36f to Color(0xFA406488), // ~98% opacity (FA = 98% in hex)
                                0.60f to Color(0xF5263C51)  // ~96% opacity (F5 = 96% in hex)
                            ),
                            start = Offset(
                                1000f * cos(Math.toRadians(310f.toDouble())).toFloat(),
                                1000f * sin(Math.toRadians(310f.toDouble())).toFloat()
                            ),
                            end = Offset(
                                0f, 0f
                            )

                        )
                    ), windowInsets = NavigationBarDefaults.windowInsets,
                containerColor = Color.Transparent

            ) {

                val navBackStackEntry = navControllerDetails.currentBackStackEntryAsState().value
                val currentRoute = navBackStackEntry?.destination?.route

                bottomNavItems.forEach { item ->

                    NavigationBarItem(
                        icon = {
                            Icon(
                                painterResource(item.icon),
                                contentDescription = item.label,
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        label = {
                            Text(
                                item.label,
                                fontSize = 10.sp,
                                fontFamily = FontFamily(Font(R.font.tajawal_700))
                            )
                        },
                        selected = currentRoute == item.route,
                        onClick = {
                            if (currentRoute != item.route) {
                                navControllerDetails.navigate(item.route) {
                                    popUpTo(navControllerDetails.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }

                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF985005),
                            unselectedIconColor = Color.White,
                            selectedTextColor = Color(0xFF985005),
                            unselectedTextColor = Color.White,
                            indicatorColor = Color.Transparent
                        ),
                        alwaysShowLabel = false // يخلي المساحة أقل
                    )
                }
            }
        }
    )
    { innerPadding ->

        NavHost(
            navController = navControllerDetails,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(innerPadding)

        )
        {
            composable(BottomNavItem.Home.route) {
                HomeNavGraph()
            }

            composable(BottomNavItem.Categories.route) {
                CategoriesNavGraph()
            }

            composable(BottomNavItem.Favorite.route) {
                FavoriteNavGraph()
            }

            composable(BottomNavItem.Account.route) {
                AccountNavGraph()
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun ProjectDetailsPagePreview() {
    ProjectDetailsPage(navController = rememberNavController())
}