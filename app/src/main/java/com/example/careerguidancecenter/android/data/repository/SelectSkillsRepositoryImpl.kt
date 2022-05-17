package com.example.careerguidancecenter.android.data.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.data.network.NetworkStorage
import com.example.careerguidancecenter.android.di.IoDispatcher
import com.example.careerguidancecenter.android.domain.models.selectSkills.SelectSkills
import com.example.careerguidancecenter.android.domain.repository.SelectSkillsRepository
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SelectSkillsRepositoryImpl
    @Inject constructor(
        private val storage: NetworkStorage,
        private val gson: Gson,
        @IoDispatcher private val dispatcher: CoroutineDispatcher
):SelectSkillsRepository {
    override suspend fun selectSkills(token: String, skillsList: List<Int>): Resource<SelectSkills> {
        return withContext(dispatcher){
            try {
                val result = storage.selectSkills(token=token,skillsList)
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