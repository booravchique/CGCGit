package com.example.careerguidancecenter.android.data.network

import com.example.careerguidancecenter.android.domain.models.answer.Answers
import com.example.careerguidancecenter.android.domain.models.getMyAnswers.GetMyAnswers
import com.example.careerguidancecenter.android.domain.models.sign.SignUpBackResult
import com.example.careerguidancecenter.android.domain.models.questions.Questions
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

}