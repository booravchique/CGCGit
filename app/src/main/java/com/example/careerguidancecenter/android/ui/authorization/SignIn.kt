package com.example.careerguidancecenter.android.ui.authorization

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavHostController
import com.example.careerguidancecenter.android.network.model.SignInInfo
import com.example.careerguidancecenter.android.network.model.SignUpInfo
import com.example.careerguidancecenter.android.ui.Nav
import com.example.careerguidancecenter.android.ui.theme.*

@Composable
fun SignIn(
    navHostController: NavHostController,
    viewModel: SignViewModel
){
    val shape = RoundedCornerShape(10.dp)

    var email = remember { mutableStateOf("") }
    var fullname = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    var confirmpassword = remember { mutableStateOf("") }

    val constraints = ConstraintSet {
        val firstChild = createRefFor("firstChild")
        val secondChild = createRefFor("secondChild")

        constrain(firstChild){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }

        constrain(secondChild){
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundFillGray)
            .padding(end = 16.dp, start = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ConstraintLayout(
            constraints,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.layoutId("firstChild"),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = "ВХОД",
                    color = DarkTextColor,
                    fontFamily = RalewayFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 38.sp,
                    textAlign = TextAlign.Center
                )
                OutlinedTextField(
                    value = fullname.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    onValueChange = { fullname.value = it },
                    placeholder = { Text("Имя") },
                    singleLine = true,
                    shape = shape,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = BorderCyan,
                        unfocusedBorderColor = BorderGray,
                        backgroundColor = Color.White
                    )
                )
                OutlinedTextField(
                    value = email.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    onValueChange = { email.value = it },
                    placeholder = { Text("Почта") },
                    singleLine = true,
                    shape = shape,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = BorderCyan,
                        unfocusedBorderColor = BorderGray,
                        backgroundColor = Color.White
                    )
                )
                OutlinedTextField(
                    value = password.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    onValueChange = { password.value = it },
                    placeholder = { Text("Пароль") },
                    singleLine = true,
                    shape = shape,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = BorderCyan,
                        unfocusedBorderColor = BorderGray,
                        backgroundColor = Color.White
                    )
                )
                OutlinedTextField(
                    value = confirmpassword.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    onValueChange = { confirmpassword.value = it },
                    placeholder = { Text("Повторите пароль") },
                    singleLine = true,
                    shape = shape,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = BorderCyan,
                        unfocusedBorderColor = BorderGray,
                        backgroundColor = Color.White
                    )
                )
                OutlinedButton(
                    modifier = Modifier
                        .padding(top = 30.dp),
                    onClick = {
                        var result = viewModel.SignIn(
                            SignInInfo(
                                fullname.value,
                                email.value,
                                password.value,
                                confirmpassword.value
                            )
                        )
                        if (result.Success) {
                            navHostController.navigate(Nav.Home.route)
                        }
                    },
                    shape = shape,
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = MainCyan
                    ),
                    border = BorderStroke(1.dp, BorderCyan),

                    )
                {
                    Text(
                        text = "ЗАРЕГИСТРИРОВАТЬСЯ",
                        fontFamily = RalewayFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
                OutlinedButton(
                    modifier = Modifier.padding(top = 8.dp),
                    onClick = {

                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color.Transparent
                    ),
                    border = BorderStroke(0.dp, Color.Transparent),
                ) {
                    Text(

                        text = "Забыли пароль?",
                        color = MainGray
                    )
                }
            }

            OutlinedButton(
                modifier = Modifier.padding(top = 8.dp).layoutId("secondChild"),
                onClick = {
                    navHostController.navigate(Nav.SignUp.route)

                },
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color.Transparent
                ),
                border = BorderStroke(0.dp, Color.Transparent),
            ) {
                Text(
                    text = "Вы уже зарегистрированы? Войдите!",
                    color = MainGray
                )
            }
        }
    }
}