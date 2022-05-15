package com.example.careerguidancecenter.android.network

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.careerguidancecenter.android.network.model.ServiceResultGeneric
import com.example.careerguidancecenter.android.network.model.SignResult
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.lang.reflect.Type

class ApiService constructor(
    var okHttpClient: OkHttpClient,
    var baseUrl: String
) {

    fun <TInput>Send(method: String, url: String, input: TInput) : String?{
        val gson = Gson()
        val jsonString = gson.toJson(input)
        val request = Request.Builder()
            .method(method,
                jsonString.toRequestBody("application/json".toMediaType()))
            .url("${baseUrl}/${url}")
            .build();

        val responseResult: MutableState<Response?> = mutableStateOf(null)
        val error = mutableStateOf(false)
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                error.value = true
            }

            override fun onResponse(call: Call, response: Response) {
                responseResult.value = response
                error.value = false
            }
        })

        while (true){
            if(responseResult.value != null){
                return responseResult.value?.body?.string()
            }

            if(error.value == true){
                throw Exception("CONNECT BAN")
            }
        }


    }
}