package com.example.careerguidancecenter.android.data.network

import com.example.careerguidancecenter.android.domain.models.SignUpBackResult
import com.google.gson.Gson


class NetworkApiStorage(private val retrofit: ApiServ,private val gson: Gson): NetworkStorage{
    override suspend fun signUpClient(hashMap: HashMap<String, String>): SignUpBackResult {
        return retrofit.postSignUn(hashMap = hashMap)
    }
}