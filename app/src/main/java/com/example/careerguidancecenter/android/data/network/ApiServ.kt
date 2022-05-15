package com.example.careerguidancecenter.android.data.network

import com.example.careerguidancecenter.android.domain.models.SignUpBackResult
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiServ {


    @POST("Authorization/SignUp")
       suspend  fun postSignUn( @Body hashMap: HashMap<String,String>): SignUpBackResult
}