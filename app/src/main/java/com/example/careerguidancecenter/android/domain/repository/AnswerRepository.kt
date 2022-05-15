package com.example.careerguidancecenter.android.domain.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.answer.Answers

interface AnswerRepository {
    suspend fun answer(hashMap: HashMap<String,Any>,token:String):Resource<Answers>
}