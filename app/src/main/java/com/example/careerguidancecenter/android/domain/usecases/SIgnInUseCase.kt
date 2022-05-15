package com.example.careerguidancecenter.android.domain.usecases

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.sign.SignUpBackResult
import com.example.careerguidancecenter.android.domain.repository.SignInRepository
import javax.inject.Inject

class SIgnInUseCase
    @Inject constructor(
        private val repository: SignInRepository
    ) {
    suspend fun execute(hashMap: HashMap<String,String>):Resource<SignUpBackResult> {
        return repository.signInRep(hashMap)
    }
}