package com.example.careerguidancecenter.android.data.network

import com.example.careerguidancecenter.android.domain.models.answer.Answers
import com.example.careerguidancecenter.android.domain.models.getAllSkills.GetAllSkills
import com.example.careerguidancecenter.android.domain.models.getMyAnswers.GetMyAnswers
import com.example.careerguidancecenter.android.domain.models.getMySelectSkills.GetMySelectSkills
import com.example.careerguidancecenter.android.domain.models.getTopProfession.GetTopProfession
import com.example.careerguidancecenter.android.domain.models.getUser.GetUser
import com.example.careerguidancecenter.android.domain.models.sign.SignUpBackResult
import com.example.careerguidancecenter.android.domain.models.questions.Questions
import com.example.careerguidancecenter.android.domain.models.selectSkills.SelectSkills
import retrofit2.http.*

interface ApiServ {


    @POST("Authorization/SignUp")
       suspend  fun postSignUn( @Body hashMap: HashMap<String,String>): SignUpBackResult
    @POST("Authorization/SignIn")
       suspend  fun postSignIn( @Body hashMap: HashMap<String,String>): SignUpBackResult
    @GET("Question/GetAllQuestions")
       suspend fun getQuestions(@Header("token")token:String,@Query("iso")lang:String = "RU"):Questions
    @POST("Answer/AddAnswer")
       suspend fun postAnswer(@Body hashMap: HashMap<String, Any>, @Header("token")token:String ):Answers
    @GET("Answer/GetMyAnswers")
       suspend fun getMyAnswers(@Header("token")token:String):GetMyAnswers
    @POST("Skill/SelectSKills")
       suspend fun postSelectSkills(@Header("token")token:String,@Body listSkills:List<Int> ):SelectSkills
    @GET("Skill/GetMySelectSKill")
       suspend fun getMySelectSkills(@Header("token")token:String):GetMySelectSkills
    @GET("Skill/GetAllSkills")
       suspend fun getAllSkills(@Header("token")token:String):GetAllSkills
    @GET("Profession/GetTopProfession")
       suspend fun getTopProfession(@Header("token")token:String):GetTopProfession
    @GET("User/Get")
       suspend fun getUser(@Header("token")token: String):GetUser


}