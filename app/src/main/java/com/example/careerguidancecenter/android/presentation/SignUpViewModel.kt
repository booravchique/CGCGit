package com.example.careerguidancecenter.android.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.sign.SignUpBackResult
import com.example.careerguidancecenter.android.domain.usecases.SIgnUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.http.Body
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val sIgnUpUseCase: SIgnUpUseCase
) :ViewModel() {


    val signUpResult = MutableLiveData<SignUpBackResult?>()
    var errorLiveData = MutableLiveData<String>()

    fun signUp(hashMap: HashMap<String,String>){
        viewModelScope.launch {
            val result = sIgnUpUseCase.execute(hashMap)
            when(result){
                is Resource.Error -> {
                    signUpResult.value = result.data
                    errorLiveData.value = result.message!!
                    Log.i("LiveDataError", result.message)
                    Log.i("LiveDataError", result.data.toString())

                }
                is Resource.Success -> {
                    Log.d("Result", result.data.toString())
                    signUpResult.value = result.data
                }
            }
        }
    }
}