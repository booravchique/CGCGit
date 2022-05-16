package com.example.careerguidancecenter.android.domain.usecases

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.selectSkills.SelectSkills
import com.example.careerguidancecenter.android.domain.repository.SelectSkillsRepository
import javax.inject.Inject

class SelectSkillsUseCase
    @Inject constructor(
    private val repository: SelectSkillsRepository
) {
    suspend fun execute(token:String,listSkills:MutableList<Int>):Resource<SelectSkills>{
        return repository.selectSkills(token,listSkills)
    }
}