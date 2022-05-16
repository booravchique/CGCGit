package com.example.careerguidancecenter.android.data.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.data.network.NetworkStorage
import com.example.careerguidancecenter.android.di.IoDispatcher
import com.example.careerguidancecenter.android.domain.models.getUser.GetUser
import com.example.careerguidancecenter.android.domain.repository.GetUserRepository
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetUserRepositoryImpl
    @Inject constructor(
        private val storage: NetworkStorage,
        private val gson: Gson,
        @IoDispatcher private val dispatcher: CoroutineDispatcher
    ):GetUserRepository{
    override suspend fun getUserRep(token: String): Resource<GetUser> {
      return  withContext(dispatcher){
            try {
                val result = storage.getUser(token)
                if (result.success){
                    Resource.Success(result)
                }
                else{
                    Resource.Error(result.errors.toString())
                }
            }
            catch (e:Exception){
                Resource.Error(e.localizedMessage ?: "Unexpected error")
            }
        }
    }
}