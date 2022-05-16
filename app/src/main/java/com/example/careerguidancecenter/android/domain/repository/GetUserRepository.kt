package com.example.careerguidancecenter.android.domain.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.getUser.GetUser

interface GetUserRepository {
    suspend fun getUserRep(token:String):Resource<GetUser>
}