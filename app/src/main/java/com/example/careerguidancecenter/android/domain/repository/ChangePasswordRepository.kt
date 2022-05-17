package com.example.careerguidancecenter.android.domain.repository

import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.changePassword.ChangePassword

interface ChangePasswordRepository {
    suspend fun changePassRep(token:String,password:String):Resource<ChangePassword>
}