package com.example.careerguidancecenter.android.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.sign.SignUpBackResult
import com.example.careerguidancecenter.android.domain.usecases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SIgnInUseCase,
    private val quest:QuestionsUseCase,
    private val ans:AnswerUseCase,
    private val getMyAnswersUseCase: GetMyAnswersUseCase
) :ViewModel() {


    val signInResult = MutableLiveData<SignUpBackResult>()


    var errorLiveData = MutableLiveData<String>()

    fun signIn(hashMap: HashMap<String,String>){
        viewModelScope.launch {
            val result = signInUseCase.execute(hashMap)
            when(result){
                is Resource.Error -> {
                    signInResult.value = result.data
                    errorLiveData.value = result.message!!
                    Log.i("LiveDataError", result.message)
                }
                is Resource.Success -> {
                    Log.d("Result", result.data.toString())
                    signInResult.value = result.data
                }
            }
        }
    }



}