package com.amrhishammahmoud.rahhal.mainScreens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.amrhishammahmoud.rahhal.R
import com.amrhishammahmoud.rahhal.viewModels.RoomViewModel
import kotlinx.coroutines.launch
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun LoginPage(navController: NavController) {


    var emailEditTextValue = remember { mutableStateOf("") }
    var passwordEditTextValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    val roomViewModel: RoomViewModel = hiltViewModel()

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
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
        contentAlignment = Alignment.BottomCenter
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rahhal_icon),
                    contentDescription = "My image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(210.dp)
                        .padding(8.dp),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Fit
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(650.dp)
                    .clip(RoundedCornerShape(topStart = 80.dp, topEnd = 80.dp))
                    .background(Color.White)
                    .padding(top = 60.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = "Let’s sign you in",
                    modifier = Modifier
                        .padding(bottom = 24.dp, start = 12.dp)
                        .alpha(0.6f),
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold))
                )


                OutlinedTextField(
                    value = emailEditTextValue.value,
                    onValueChange = { emailEditTextValue.value = it },
                    label = { Text("E-mail") },
                    placeholder = { Text("Enter Your Email") },
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .alpha(0.7f)
                        .fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "Email Icon"
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xFFEBEFEE),
                        unfocusedContainerColor = Color(0xFFEBEFEE),


                        )
                )

                Spacer(modifier = Modifier.height(4.dp))


                OutlinedTextField(
                    value = passwordEditTextValue.value,
                    onValueChange = { passwordEditTextValue.value = it },
                    label = { Text("Password") },
                    placeholder = { Text("Enter Your Password") },
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .alpha(0.7f)
                        .fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = "Password Icon"
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.eye_icon),
                                contentDescription = "hidden icon"
                            )
                        }
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xFFEBEFEE),
                        unfocusedContainerColor = Color(0xFFEBEFEE),
                    ),
                    visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth(), contentAlignment = Alignment.TopEnd
                ) {


                    TextButton(onClick = { /*TODO*/ }) {
                        Text(
                            text = "forget password?",
                            modifier = Modifier.alpha(0.8f),
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_regular)),
                            textDecoration = TextDecoration.Underline
                        )
                    }
                }


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .padding(top = 18.dp)
                        .background(Color.White),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    TextButton(
                        onClick = {

                            if (emailEditTextValue.value.isEmpty() || passwordEditTextValue.value.isEmpty()) {
                                Toast.makeText(
                                    context,
                                    "Enter your E-mail & Password !",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {

                                coroutineScope.launch {
                                    val userEntity = roomViewModel.login(
                                        emailEditTextValue.value,
                                        passwordEditTextValue.value
                                    )
                                    if (userEntity == null) {
                                        Toast.makeText(
                                            context,
                                            "Invalid Credentials !, Sign up first and login !",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        Toast.makeText(context, "Welcoming", Toast.LENGTH_SHORT)
                                            .show()

                                        val sharedPref = context.getSharedPreferences(
                                            "user_prefs",
                                            Context.MODE_PRIVATE
                                        )
                                        sharedPref.edit()
                                            .putString("user_email", emailEditTextValue.value)
                                            .apply()
                                        sharedPref.edit()
                                            .putString("user_password", passwordEditTextValue.value)
                                            .apply()

                                        sharedPref.edit().putBoolean("is_logged_in", true).apply()

                                        navController.navigate("detailsProject")
                                    }
                                }


                            }

                        },
                        modifier = Modifier
                            .width(200.dp)
                            .height(60.dp)
                            .padding(bottom = 4.dp)
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

                                ),
                                shape = RoundedCornerShape(28.dp)
                            )
                            .padding(4.dp),
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = Color.Transparent
                        )
                    )

                    {
                        Text(
                            text = "Login",
                            modifier = Modifier.padding(4.dp),
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            fontSize = 20.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        HorizontalDivider(
                            modifier = Modifier
                                .weight(1f)
                                .width(1.dp)
                                .alpha(0.5f),
                            thickness = 1.dp, color = Color.Black
                        )
                        Text(
                            text = "Or login with",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_regular)),
                            modifier = Modifier.alpha(0.8f)
                        )
                        HorizontalDivider(
                            modifier = Modifier
                                .weight(1f)
                                .width(1.dp)
                                .alpha(0.5f),
                            thickness = 1.dp, color = Color.Black
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(Color.White),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {

                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            )
                        )
                        {
                            Image(
                                painter = painterResource(R.drawable.facebook_icon),
                                contentDescription = "Facebook Icon",
                                modifier = Modifier.size(40.dp)
                            )
                        }


                        Spacer(modifier = Modifier.width(20.dp))

                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            )
                        )
                        {
                            Image(
                                painter = painterResource(R.drawable.google_icon),
                                contentDescription = "Gmail Icon",
                                modifier = Modifier.size(40.dp)
                            )

                        }

                        Spacer(modifier = Modifier.width(20.dp))

                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            )
                        )
                        {
                            Image(
                                painter = painterResource(R.drawable.phone_icon),
                                contentDescription = "Phone Icon",
                                modifier = Modifier.size(40.dp)
                            )

                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .background(Color.White),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {

                        Text(
                            modifier = Modifier
                                .alpha(0.6f)
                                .padding(start = 12.dp),
                            text = "Don’t have an account?",
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_regular))
                        )

                        Spacer(modifier = Modifier.width(2.dp))

                        Text(
                            modifier = Modifier
                                .fillMaxHeight()
                                .clickable(
                                    onClick = { navController.navigate("signup") }
                                ),
                            text = "Sign up",
                            textAlign = TextAlign.Start,
                            color = Color.Black,
                            fontSize = 16.sp,
                            textDecoration = TextDecoration.Underline,
                            fontFamily = FontFamily(Font(R.font.roboto_bold))
                        )


                    }

                }


            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPage(navController = rememberNavController())
}