package com.example.careerguidancecenter.android.domain.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.getTopProfession.GetTopProfession

interface GetProfessionRepository {
    suspend fun getProfession(token:String,id:Int):Resource<GetTopProfession>
}