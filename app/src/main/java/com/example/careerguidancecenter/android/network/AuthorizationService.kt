package com.example.careerguidancecenter.android.network

import com.example.careerguidancecenter.android.network.model.ServiceResultGeneric
import com.example.careerguidancecenter.android.network.model.SignResult
import com.example.careerguidancecenter.android.network.model.SignUpInfo
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthorizationService {

    @POST("Authorization/SignUp")
    suspend fun SignUp(@Body signUpInfo: SignUpInfo): ApiResponse<ServiceResultGeneric<SignResult>>
}