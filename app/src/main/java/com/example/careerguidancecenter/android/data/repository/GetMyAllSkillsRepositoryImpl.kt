package com.example.careerguidancecenter.android.data.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.data.network.NetworkStorage
import com.example.careerguidancecenter.android.di.IoDispatcher
import com.example.careerguidancecenter.android.domain.models.getAllSkills.GetAllSkills
import com.example.careerguidancecenter.android.domain.repository.GetAllSkillsRepository
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMyAllSkillsRepositoryImpl
    @Inject constructor(
        private val storage: NetworkStorage,
        private val gson: Gson,
        @IoDispatcher private val dispatcher: CoroutineDispatcher
    ):GetAllSkillsRepository {
    override suspend fun getAllSkillsRep(): Resource<GetAllSkills> {
      return  withContext(dispatcher){
            try {
                val result = storage.getAllSKills()
                if (result.success){
                    Resource.Success(result)
                }
                else{
                    Resource.Error(result.errors.toString())
                }
            }
            catch (e:Exception){
                Resource.Error(e.localizedMessage ?:"Unexpected error")
            }
        }
    }

}