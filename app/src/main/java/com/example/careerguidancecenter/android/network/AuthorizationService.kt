package com.example.careerguidancecenter.android.network

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.careerguidancecenter.android.Token
import com.example.careerguidancecenter.android.network.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.lang.reflect.Type

class AuthorizationService constructor(
    var apiService: ApiService,
) {

    fun SignUp(signUpInfo: SignUpInfo): ServiceResultGeneric<SignResult?>{
        val gson = Gson()
        var result = apiService.Send<SignUpInfo>("POST",
            "Authorization/SignUp", signUpInfo)
        println(result)
        val type: Type = object :
            TypeToken<ServiceResultGeneric<SignResult?>>() {}.type
        var resultObject = gson.fromJson<ServiceResultGeneric<SignResult?>>(result, type)
        if(resultObject.Value != null)
            Token = resultObject.Value?.Token

        return resultObject
    }

    fun SignIn(signInInfo: SignInInfo): ServiceResultGeneric<SignResult?>{

        val gson = Gson()
        val result =
            apiService.Send("POST",
            "Authorization/SignIn", signInInfo)

        val type: Type = object :
            TypeToken<ServiceResultGeneric<SignResult?>>() {}.type
        var resultObject = gson.fromJson<ServiceResultGeneric<SignResult?>>(result, type)

        if(resultObject.Value != null)
            Token = resultObject.Value?.Token

        return resultObject
    }
}