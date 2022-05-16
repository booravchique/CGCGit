package com.example.careerguidancecenter.android.data.repository

import android.util.Log
import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.data.network.NetworkStorage
import com.example.careerguidancecenter.android.di.IoDispatcher
import com.example.careerguidancecenter.android.domain.models.sign.SignUpBackResult
import com.example.careerguidancecenter.android.domain.repository.SignInRepository
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

class SignInRepositoryImpl
    @Inject constructor(
        private val storage: NetworkStorage,
        private val gson: Gson,
        @IoDispatcher private val dispatcher: CoroutineDispatcher):SignInRepository {
    override suspend fun signInRep(hashMap: HashMap<String, String>): Resource<SignUpBackResult> {
        return withContext(dispatcher) {
            var result:SignUpBackResult? = null
            try {
                val result = storage.signInClient(hashMap = hashMap)
                if (result.httpStatusCode == 200) {
                    Resource.Success(result)
                } else {
                    Resource.Error("FAIL", result)
                }
            }
            catch (e: HttpException) {
                val json = e.response()?.errorBody()?.string()
                //TODO
                Resource.Error(e.localizedMessage ?: "Unexpected error", result)
            }
            catch (e: Exception) {
                Resource.Error(e.localizedMessage ?: "Unexpected error", result)
            }
        }
    }
}