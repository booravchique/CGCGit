package com.example.careerguidancecenter.android

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import coil.util.CoilUtils
import com.example.careerguidancecenter.android.network.RequestInterceptor
import com.example.careerguidancecenter.android.network.model.ServiceResultGeneric
import com.example.careerguidancecenter.android.network.model.SignResult
import com.example.careerguidancecenter.android.network.model.SignUpInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.junit.Test

import org.junit.Assert.*
import java.io.IOException
import java.lang.reflect.Type

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {


        var http = provideOkHttpClient()
        var request = request()


        var responseM: MutableState<Response?> = mutableStateOf(null)
        var error = mutableStateOf(false)

        http.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                error.value = true
            }

            override fun onResponse(call: Call, response: Response) {
                error.value = false
                responseM.value = response
            }
        })

        while (true){
            if(responseM.value != null){
                var gson = Gson()

                var dff = responseM.value?.body?.string()
                val type: Type = object : TypeToken<ServiceResultGeneric<SignResult?>>() {}.type
                var frgrrg = gson.fromJson<ServiceResultGeneric<SignResult?>>(dff, type)
                println(dff)
            }

            if(error.value == true){
                println(error.value)

            }
        }
    }

    fun request() : Request{

        var gson = Gson()
        var jsonString = gson.toJson(SignUpInfo("FUBiurbriv","fi876fmagrgggrgrrfrg@gmail.com", "frgrа89нкGUUVJа9*gr"))

        println(jsonString)
        return Request.Builder()
            .method("POST", jsonString.toRequestBody("application/json".toMediaType()))
            .url("https://fm.tringle.org/api/Authorization/SignUp")
            .build();
    }

    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .build()
    }
}