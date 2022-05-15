package com.example.careerguidancecenter.android.data.network

import com.example.careerguidancecenter.android.domain.models.SignUpBackResult

interface NetworkStorage {
    suspend fun signUpClient(hashMap: HashMap<String,String>): SignUpBackResult
}