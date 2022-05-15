package com.example.careerguidancecenter.android.ui.authorization

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.careerguidancecenter.android.network.AuthorizationService
import com.example.careerguidancecenter.android.network.model.ServiceResultGeneric
import com.example.careerguidancecenter.android.network.model.SignInInfo
import com.example.careerguidancecenter.android.network.model.SignResult
import com.example.careerguidancecenter.android.network.model.SignUpInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignViewModel@Inject constructor(
    var authorizationService : AuthorizationService
) : ViewModel() {

    fun SignUp(signUpInfo : SignUpInfo): ServiceResultGeneric<SignResult?> {
        return authorizationService.SignUp(signUpInfo)
    }

    fun SignIn(signInInfo: SignInInfo): ServiceResultGeneric<SignResult?> {
        return authorizationService.SignIn(signInInfo)
    }
}