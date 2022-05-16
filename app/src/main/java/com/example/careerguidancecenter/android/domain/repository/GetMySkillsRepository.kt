package com.example.careerguidancecenter.android.domain.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.getMySelectSkills.GetMySelectSkills

interface GetMySkillsRepository {
    suspend fun getMySelectSkills(token:String):Resource<GetMySelectSkills>
}