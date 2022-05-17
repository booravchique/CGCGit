package com.example.careerguidancecenter.android.domain.usecases

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.getTopProfession.GetTopProfession
import com.example.careerguidancecenter.android.domain.repository.GetProfessionRepository
import javax.inject.Inject

class GetProfessionUseCase
    @Inject constructor(
        private val repository: GetProfessionRepository
    ){
        suspend fun execute(token:String,id:Int):Resource<GetTopProfession>{
            return repository.getProfession(token,id)
        }
}