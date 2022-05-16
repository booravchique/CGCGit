package com.example.careerguidancecenter.android.ui.authorization

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.careerguidancecenter.android.Token
import com.example.careerguidancecenter.android.domain.models.sign.SignUpBackResult
import com.example.careerguidancecenter.android.network.model.ServiceResultGeneric
import com.example.careerguidancecenter.android.network.model.SignResult
import com.example.careerguidancecenter.android.network.model.SignUpInfo
import com.example.careerguidancecenter.android.presentation.SignInViewModel
import com.example.careerguidancecenter.android.presentation.SignUpViewModel
import com.example.careerguidancecenter.android.ui.Nav
import com.example.careerguidancecenter.android.ui.theme.*
import dagger.hilt.android.AndroidEntryPoint

@Composable

fun SignUp(
    navHostController: NavHostController,
    viewModel: SignInViewModel = viewModel()

) {

    var errorLiveData : State<String?> = viewModel.errorLiveData.observeAsState()
    var signInResult : State<SignUpBackResult?> = viewModel.signInResult.observeAsState()


    val shape = RoundedCornerShape(10.dp)

    var fullName = remember { mutableStateOf("dimastd333@gmail.com") }
    var password = remember { mutableStateOf("QAZqaz_123") }

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
                    value = fullName.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    onValueChange = { fullName.value = it },
                    placeholder = { Text("Имя", color = MainGray) },
                    singleLine = true,
                    shape = shape,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = BorderCyan,
                        unfocusedBorderColor = BorderGray,
                        backgroundColor = White
                    )
                )
                OutlinedTextField(
                    value = password.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    onValueChange = { password.value = it },
                    placeholder = { Text("Пароль", color = MainGray) },
                    singleLine = true,
                    shape = shape,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = BorderCyan,
                        unfocusedBorderColor = BorderGray,
                        backgroundColor = White
                    )
                )

                OutlinedButton(
                    modifier = Modifier
                        .padding(top = 30.dp),
                    onClick = {
                        val login = fullName.value
                        val password = password.value
                        if(password == null ||
                            fullName == null)
                            return@OutlinedButton

                        val hashMap:HashMap<String, String> = hashMapOf()
                        hashMap.put("password", password)
                        hashMap.put("email", login)
                        viewModel.signIn(hashMap)
                              },
                    shape = shape,
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = MainCyan
                    ),
                    border = BorderStroke(1.dp, BorderCyan),

                    )
                {
                    Text(
                        modifier = Modifier.padding(bottom = 2.dp),
                        text = "ВОЙТИ",
                        fontFamily = RalewayFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = White,
                        textAlign = TextAlign.Center
                    )
                }
                OutlinedButton(
                    modifier = Modifier.padding(top = 8.dp),
                    onClick = {

                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Transparent
                    ),
                    border = BorderStroke(0.dp, Transparent),
                ) {
                    Text(

                        text = "Забыли пароль?",
                        color = MainGray
                    )
                }

                if(errorLiveData.value != null || signInResult.value?.success == false){

                    signInResult.value?.errors?.forEach{
                        Text(

                            text = it.name,
                            color = MainGray
                        )
                    }
                }
            }

            OutlinedButton(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .layoutId("secondChild"),
                onClick = {
                    navHostController.navigate(Nav.SignIn.route)
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Transparent
                ),
                border = BorderStroke(0.dp, Transparent),
            ) {
                Text(
                    text = "У вас нет учетной записи? Создайте ее!",
                    color = MainGray
                )
            }

            var isLoad = remember{ mutableStateOf(false)}

            if(signInResult.value?.success == true && !isLoad.value){
                isLoad.value = true

                navHostController.navigate(Nav.Home.route)

                Token = signInResult.value?.value?.token
            }
        }
    }
}

