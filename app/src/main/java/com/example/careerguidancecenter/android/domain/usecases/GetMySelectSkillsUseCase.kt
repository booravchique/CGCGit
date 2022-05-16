package com.example.careerguidancecenter.android.domain.usecases

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.getMySelectSkills.GetMySelectSkills
import com.example.careerguidancecenter.android.domain.repository.GetMySkillsRepository
import javax.inject.Inject

class GetMySelectSkillsUseCase @Inject constructor(
    private val repository: GetMySkillsRepository
) {
    suspend fun execute(token:String):Resource<GetMySelectSkills>{
        return repository.getMySelectSkills(token)
    }
}