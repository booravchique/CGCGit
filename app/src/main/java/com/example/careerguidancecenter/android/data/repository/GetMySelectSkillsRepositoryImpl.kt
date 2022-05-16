package com.example.careerguidancecenter.android.data.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.data.network.NetworkStorage
import com.example.careerguidancecenter.android.di.IoDispatcher
import com.example.careerguidancecenter.android.domain.models.getMyAnswers.GetMyAnswers
import com.example.careerguidancecenter.android.domain.models.getMySelectSkills.GetMySelectSkills
import com.example.careerguidancecenter.android.domain.repository.GetMyAnswersRepository
import com.example.careerguidancecenter.android.domain.repository.GetMySkillsRepository
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMySelectSkillsRepositoryImpl
    @Inject constructor(
        private val storage: NetworkStorage,
        private val gson: Gson,
        @IoDispatcher private val dispatcher: CoroutineDispatcher
    ): GetMySkillsRepository{
    override suspend fun getMySelectSkills(token: String): Resource<GetMySelectSkills>  {
      return  withContext(dispatcher){
            try {
                val result = storage.getMySelectSkills(token)
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