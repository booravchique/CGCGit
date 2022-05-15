package com.example.careerguidancecenter.android.domain.usecases

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.answer.Answers
import com.example.careerguidancecenter.android.domain.repository.AnswerRepository
import javax.inject.Inject

class AnswerUseCase
    @Inject constructor(private  val repository: AnswerRepository){
    suspend fun execute(hashMap: HashMap<String,Any>,token:String):Resource<Answers>{
        return repository.answer(hashMap = hashMap, token = token)
    }
}