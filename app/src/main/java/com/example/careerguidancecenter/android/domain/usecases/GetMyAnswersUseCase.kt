package com.example.careerguidancecenter.android.domain.usecases

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.getMyAnswers.GetMyAnswers
import com.example.careerguidancecenter.android.domain.repository.GetMyAnswersRepository
import javax.inject.Inject

class GetMyAnswersUseCase
    @Inject constructor(
        private val repository: GetMyAnswersRepository
    ) {
        suspend fun execute(token:String):Resource<GetMyAnswers>{
            return repository.getMyAnswers(token = token)
        }
}