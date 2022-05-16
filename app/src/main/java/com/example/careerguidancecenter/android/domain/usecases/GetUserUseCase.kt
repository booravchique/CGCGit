package com.example.careerguidancecenter.android.domain.usecases

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.getUser.GetUser
import com.example.careerguidancecenter.android.domain.repository.GetUserRepository
import javax.inject.Inject

class GetUserUseCase
    @Inject constructor(
        private val repository: GetUserRepository
    ){
        suspend fun execute(token:String):Resource<GetUser>{
            return repository.getUserRep(token = token)
        }
}