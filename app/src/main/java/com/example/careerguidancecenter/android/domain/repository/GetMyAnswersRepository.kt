package com.example.careerguidancecenter.android.domain.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.getMyAnswers.GetMyAnswers

interface GetMyAnswersRepository {
    suspend fun getMyAnswers(token:String):Resource<GetMyAnswers>
}