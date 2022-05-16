package com.example.careerguidancecenter.android.data.network

import com.example.careerguidancecenter.android.domain.models.answer.Answers
import com.example.careerguidancecenter.android.domain.models.getAllSkills.GetAllSkills
import com.example.careerguidancecenter.android.domain.models.getMyAnswers.GetMyAnswers
import com.example.careerguidancecenter.android.domain.models.getMySelectSkills.GetMySelectSkills
import com.example.careerguidancecenter.android.domain.models.getTopProfession.GetTopProfession
import com.example.careerguidancecenter.android.domain.models.sign.SignUpBackResult
import com.example.careerguidancecenter.android.domain.models.questions.Questions
import com.example.careerguidancecenter.android.domain.models.selectSkills.SelectSkills
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

    override suspend fun getMyAnswers(token: String): GetMyAnswers {
        return retrofit.getMyAnswers(token = token)
    }

    override suspend fun selectSkills(token: String, listSkills: MutableList<Int>):SelectSkills {
        return retrofit.postSelectSkills(token = token, listSkills = listSkills)
    }

    override suspend fun getMySelectSkills(token: String): GetMySelectSkills {
        return retrofit.getMySelectSkills(token = token)
    }

    override suspend fun getAllSKills(): GetAllSkills {
        return retrofit.getAllSkills()
    }

    override suspend fun getTopProfession(): GetTopProfession {
        return retrofit.getTopProfession()
    }


}