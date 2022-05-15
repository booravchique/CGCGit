package com.example.careerguidancecenter.android.domain.usecases

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.SignUpBackResult
import com.example.careerguidancecenter.android.domain.repository.SignUpRepository
import javax.inject.Inject

class SIgnUpUseCase
    @Inject constructor(
        private val repository: SignUpRepository
    ) {
    suspend fun execute(hashMap: HashMap<String,String>):Resource<SignUpBackResult> {
        return repository.signUpRep(hashMap)
    }
}