package com.example.careerguidancecenter.android.domain.usecases

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.getTopProfession.GetTopProfession
import com.example.careerguidancecenter.android.domain.repository.GetTopProfessionRepository
import javax.inject.Inject

class GetTopProfessionUseCase
    @Inject constructor(
       private val repository: GetTopProfessionRepository){
        suspend fun execute(token: String):Resource<GetTopProfession>{
            return repository.getTopProfessionRep(token)
        }
}