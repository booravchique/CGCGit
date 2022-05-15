package com.example.careerguidancecenter.android.data.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.data.network.NetworkStorage
import com.example.careerguidancecenter.android.di.IoDispatcher
import com.example.careerguidancecenter.android.domain.models.SignUpBackResult
import com.example.careerguidancecenter.android.domain.repository.SignUpRepository
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class SignUpRepositoryImpl
    @Inject constructor(
        private val storage: NetworkStorage,
        private val gson: Gson,
        @IoDispatcher private val dispatcher: CoroutineDispatcher):SignUpRepository {
    override suspend fun signUpRep(hashMap: HashMap<String, String>): Resource<SignUpBackResult> {
        return withContext(dispatcher) {
            try {
                val result = storage.signUpClient(hashMap = hashMap)
                if (result.httpStatusCode == 200) {
                    Resource.Success(result)
                } else {
                    Resource.Error("FAIL")
                }
            } catch (e: Exception) {
                Resource.Error(e.localizedMessage ?: "Unexpected error")
            }
        }
    }
}