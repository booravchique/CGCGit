package com.example.careerguidancecenter.android.domain.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.questions.Questions

interface QuestionsRepository {
    suspend fun getQuestions(token:String):Resource<Questions>
}