package com.example.careerguidancecenter.android.data.network

import com.example.careerguidancecenter.android.domain.models.answer.Answers
import com.example.careerguidancecenter.android.domain.models.sign.SignUpBackResult
import com.example.careerguidancecenter.android.domain.models.questions.Questions

interface NetworkStorage {
    suspend fun signUpClient(hashMap: HashMap<String,String>): SignUpBackResult
    suspend fun signInClient(hashMap: HashMap<String,String>) : SignUpBackResult
    suspend fun questions(token:String):Questions
    suspend fun answers(hashMap: HashMap<String,Any>,token: String):Answers
}