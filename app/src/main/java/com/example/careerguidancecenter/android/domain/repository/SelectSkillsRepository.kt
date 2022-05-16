package com.example.careerguidancecenter.android.domain.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.selectSkills.SelectSkills

interface SelectSkillsRepository {
    suspend fun selectSkills(token:String,skillsList:MutableList<Int>):Resource<SelectSkills>
}