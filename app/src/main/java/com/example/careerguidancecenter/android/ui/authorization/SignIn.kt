package com.example.careerguidancecenter.android.ui.authorization

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.careerguidancecenter.android.network.model.ServiceResultGeneric
import com.example.careerguidancecenter.android.network.model.SignResult
import com.example.careerguidancecenter.android.network.model.SignUpInfo
import com.example.careerguidancecenter.android.ui.theme.BackgroundFillGray


@Preview
@Composable
fun SignIn(){
    var fullName = remember { mutableStateOf("") }
    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    val viewModel: SignViewModel = viewModel()

    var result = remember{ mutableStateOf(ServiceResultGeneric<SignResult?>
        (0, false, listOf(), null)) }

    var isLoad = remember { mutableStateOf(false) }

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

                    value =  fullName.value,
                    modifier = Modifier
                        .fillMaxWidth(),
                    onValueChange = { fullName.value = it },
                    label = { Text("ФИО") },
                    singleLine = true

                )

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
                        var resultff = viewModel.SignUp(
                            SignUpInfo(
                                fullName.value,
                                email.value,
                                password.value
                            )
                        )

                        result.value = resultff

                        isLoad.value = true
                    },

                )
                {
                    Text("Пароль")
                }

                println(result.value.Success)
                if(isLoad.value == true){
                    println("FFFCERF")
                    OutlinedTextField(

                        value =  result.value.Value?.Token ?: "null",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        onValueChange = { password.value = it },
                        label = { Text(result.value.Value?.Token ?: "null") },
                        singleLine = true

                    )
                }
            }

        }


    }


}