package com.example.careerguidancecenter.android.domain.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.sign.SignUpBackResult

interface SignUpRepository {
    suspend fun signUpRep(hashMap: HashMap<String,String>): Resource<SignUpBackResult>
}