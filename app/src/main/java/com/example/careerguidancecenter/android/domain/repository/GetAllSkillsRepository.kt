package com.example.careerguidancecenter.android.domain.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.getAllSkills.GetAllSkills

interface GetAllSkillsRepository {
    suspend fun getAllSkillsRep(token: String):Resource<GetAllSkills>
}