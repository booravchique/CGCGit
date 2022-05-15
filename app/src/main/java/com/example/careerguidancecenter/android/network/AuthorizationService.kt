package com.example.careerguidancecenter.android.network

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.careerguidancecenter.android.network.model.ServiceError
import com.example.careerguidancecenter.android.network.model.ServiceResultGeneric
import com.example.careerguidancecenter.android.network.model.SignResult
import com.example.careerguidancecenter.android.network.model.SignUpInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.lang.reflect.Type

class AuthorizationService constructor(
    var okHttpClient: OkHttpClient,
    var baseUrl: String
) {

    fun SignUp(signUpInfo: SignUpInfo): ServiceResultGeneric<SignResult?>{
        var gson = Gson()
        var jsonString = gson.toJson(signUpInfo)
        println(jsonString)
        val request = Request.Builder()
            .method("POST",
                jsonString.toRequestBody("application/json".toMediaType()))
            .url("${baseUrl}/Authorization/SignUp")
            .build();

        var responseM: MutableState<Response?> = mutableStateOf(null)

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

                println("ERROR")
            }

            override fun onResponse(call: Call, response: Response) {
                responseM.value = response
            }
        })

        while (true){
            if(responseM.value != null){
                val jsonInString = responseM.value?.body?.string()
                println(jsonInString ?: "FFFFF NUUULL")
                val type: Type = object : TypeToken<ServiceResultGeneric<SignResult?>>() {}.type
                return gson.fromJson(jsonInString, type)
            }
            println("NNNN")
        }
    }
}