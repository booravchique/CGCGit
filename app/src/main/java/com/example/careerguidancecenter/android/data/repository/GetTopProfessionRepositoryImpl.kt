package com.example.careerguidancecenter.android.data.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.data.network.NetworkStorage
import com.example.careerguidancecenter.android.di.IoDispatcher
import com.example.careerguidancecenter.android.domain.models.getTopProfession.GetTopProfession
import com.example.careerguidancecenter.android.domain.repository.GetTopProfessionRepository
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetTopProfessionRepositoryImpl
    @Inject constructor(
        private val storage: NetworkStorage,
        private val gson: Gson,
        @IoDispatcher private val dispatcher: CoroutineDispatcher
    ):GetTopProfessionRepository{
    override suspend fun getTopProfessionRep(): Resource<GetTopProfession> {
       return withContext(dispatcher){
            try {
                val result = storage.getTopProfession()
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