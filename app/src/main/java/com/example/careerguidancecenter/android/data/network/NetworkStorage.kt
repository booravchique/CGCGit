package com.example.careerguidancecenter.android.data.network

import com.example.careerguidancecenter.android.domain.models.answer.Answers
import com.example.careerguidancecenter.android.domain.models.getAllSkills.GetAllSkills
import com.example.careerguidancecenter.android.domain.models.getMyAnswers.GetMyAnswers
import com.example.careerguidancecenter.android.domain.models.getMySelectSkills.GetMySelectSkills
import com.example.careerguidancecenter.android.domain.models.sign.SignUpBackResult
import com.example.careerguidancecenter.android.domain.models.questions.Questions
import com.example.careerguidancecenter.android.domain.models.selectSkills.SelectSkills

interface NetworkStorage {
    suspend fun signUpClient(hashMap: HashMap<String,String>): SignUpBackResult
    suspend fun signInClient(hashMap: HashMap<String,String>) : SignUpBackResult
    suspend fun questions(token:String):Questions
    suspend fun answers(hashMap: HashMap<String,Any>,token: String):Answers
    suspend fun getMyAnswers(token:String):GetMyAnswers
    suspend fun selectSkills(token: String,listSkills: MutableList<Int>):SelectSkills
    suspend fun getMySelectSkills(token: String):GetMySelectSkills
    suspend fun getAllSKills():GetAllSkills
}