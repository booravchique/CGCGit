package com.example.careerguidancecenter.android.ui.authorization

import androidx.lifecycle.ViewModel
import com.example.careerguidancecenter.android.network.AuthorizationService
import com.example.careerguidancecenter.android.network.model.SignUpInfo
import javax.inject.Inject

class SignViewModel@Inject constructor(
    var authorizationService : AuthorizationService
) : ViewModel() {

    suspend fun SignUp(signUpInfo : SignUpInfo){
        var result = authorizationService.SignUp(signUpInfo)
    }

}