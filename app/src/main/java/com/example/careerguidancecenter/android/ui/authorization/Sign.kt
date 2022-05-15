package com.example.careerguidancecenter.android.ui.authorization

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.careerguidancecenter.android.Token
import com.example.careerguidancecenter.android.presentation.SignInViewModel
import com.example.careerguidancecenter.android.presentation.SignUpViewModel
import com.example.careerguidancecenter.android.ui.Nav
import com.example.careerguidancecenter.android.ui.main.LevelsLayoutScreen
import com.example.careerguidancecenter.android.ui.theme.BackgroundFillGray
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@Preview
@Composable
fun Sign (){
    val navController = rememberNavController()
    val viewModel: SignViewModel = viewModel()
    val signUpViewModel = hiltViewModel<SignUpViewModel>()
    val signInViewModel = hiltViewModel<SignInViewModel>()
    var startRoute = Nav.Start.route
    if(Token != null){
        startRoute = Nav.Home.route
    }
    NavHost(navController = navController, startDestination = startRoute) {
        composable(Nav.Start.route){

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BackgroundFillGray)
                    .padding(end = 15.dp, start = 15.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BackgroundFillGray)
                )
                {
                    Column() {
                        OutlinedButton(

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            onClick = {
                                navController.navigate(Nav.SignIn.route)


                            },

                            )
                        {
                            Text("Вход")
                        }

                        OutlinedButton(

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            onClick = {
                                navController.navigate(Nav.SignUp.route)


                            },

                            )
                        {
                            Text("Регистрация")
                        }

                        OutlinedButton(

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            onClick = {
                                      navController.navigate(Nav.Home.route)

                            },

                            )
                        {
                            Text("Главная")
                        }
                    }

                }


            }
        }
        composable(Nav.Home.route){
            LevelsLayoutScreen()
        }
        composable(Nav.SignUp.route){
            SignUp(navController, signInViewModel)
        }
        composable(Nav.SignIn.route){
            SignIn(navController, signUpViewModel)
        }

    }



}