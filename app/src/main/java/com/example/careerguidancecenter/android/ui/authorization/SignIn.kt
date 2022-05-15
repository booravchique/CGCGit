package com.example.careerguidancecenter.android.ui.authorization

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.careerguidancecenter.android.network.model.SignInInfo
import com.example.careerguidancecenter.android.network.model.SignUpInfo
import com.example.careerguidancecenter.android.ui.Nav
import com.example.careerguidancecenter.android.ui.theme.BackgroundFillGray

@Composable
fun SignIn(
    navHostController: NavHostController,
    viewModel: SignViewModel
){
    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }

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
                OutlinedTextField(

                    value =  email.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    onValueChange = { email.value = it },
                    label = { Text("Почта") },
                    singleLine = true

                )

                OutlinedTextField(

                    value =  password.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    onValueChange = { password.value = it },
                    label = { Text("Пароль") },
                    singleLine = true

                )

                OutlinedButton(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    onClick = {
                        var result = viewModel.SignIn(
                            SignInInfo(
                                email.value,
                                password.value
                            )
                        )

                        if(result.Success){
                            navHostController.navigate(Nav.Home.route)
                        }
                    },

                    )
                {
                    Text("Отправить")
                }

            }

        }


    }


}