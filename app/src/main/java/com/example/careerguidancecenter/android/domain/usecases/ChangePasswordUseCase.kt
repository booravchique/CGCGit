package com.example.careerguidancecenter.android.domain.usecases

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.changePassword.ChangePassword
import com.example.careerguidancecenter.android.domain.repository.ChangePasswordRepository
import javax.inject.Inject

class ChangePasswordUseCase
    @Inject constructor(
        private val repository: ChangePasswordRepository
    ) {
    suspend fun execute(token:String,password:String):Resource<ChangePassword>{
        return repository.changePassRep(token,password)
    }
}