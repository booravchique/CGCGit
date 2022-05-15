package com.example.careerguidancecenter.android.data.network

import com.example.careerguidancecenter.android.domain.models.answer.Answers
import com.example.careerguidancecenter.android.domain.models.sign.SignUpBackResult
import com.example.careerguidancecenter.android.domain.models.questions.Questions
import com.google.gson.Gson


class NetworkApiStorage(private val retrofit: ApiServ,private val gson: Gson): NetworkStorage{
    override suspend fun signUpClient(hashMap: HashMap<String, String>): SignUpBackResult {
        return retrofit.postSignUn(hashMap = hashMap)
    }

    override suspend fun signInClient(hashMap: HashMap<String, String>): SignUpBackResult {
        return retrofit.postSignIn(hashMap = hashMap)
    }

    override suspend fun questions(token:String):Questions{
        return retrofit.getQuestions(token = token)
    }

    override suspend fun answers(hashMap: HashMap<String, Any>, token: String): Answers {
        return retrofit.postAnswer(hashMap=hashMap,token = token)
    }

}