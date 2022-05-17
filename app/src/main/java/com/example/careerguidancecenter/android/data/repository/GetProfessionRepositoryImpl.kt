package com.example.careerguidancecenter.android.data.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.data.network.NetworkStorage
import com.example.careerguidancecenter.android.di.IoDispatcher
import com.example.careerguidancecenter.android.domain.models.getTopProfession.GetTopProfession
import com.example.careerguidancecenter.android.domain.repository.GetProfessionRepository
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetProfessionRepositoryImpl
    @Inject constructor(
        private val storage: NetworkStorage,
        private val gson: Gson,
        @IoDispatcher private val dispatcher: CoroutineDispatcher
    ):GetProfessionRepository{
    override suspend fun getProfession(token: String, id: Int): Resource<GetTopProfession> {
       return withContext(dispatcher){
            try {
                val result = storage.getProfession(token,id)
                if (result.success){
                    Resource.Success(result)
                }else{
                    Resource.Error(result.errors.toString())
                }
            }catch (e:Exception){
                    Resource.Error(e.localizedMessage ?: "Unexpected error")
            }
        }
    }
}