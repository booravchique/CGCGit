package com.example.careerguidancecenter.android.domain.usecases

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.questions.Questions
import com.example.careerguidancecenter.android.domain.repository.QuestionsRepository
import javax.inject.Inject

class QuestionsUseCase @Inject constructor(
    private val repository: QuestionsRepository
) {
    suspend fun execute(token:String):Resource<Questions>{
        return repository.getQuestions(token)
    }
}