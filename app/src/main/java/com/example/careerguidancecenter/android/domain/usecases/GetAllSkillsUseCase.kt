package com.example.careerguidancecenter.android.domain.usecases


import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.getAllSkills.GetAllSkills
import com.example.careerguidancecenter.android.domain.repository.GetAllSkillsRepository
import javax.inject.Inject

class GetAllSkillsUseCase
    @Inject constructor(
        private val repository:GetAllSkillsRepository
    ){
    suspend fun execute(token: String):Resource<GetAllSkills>{
        return repository.getAllSkillsRep(token)
    }
}