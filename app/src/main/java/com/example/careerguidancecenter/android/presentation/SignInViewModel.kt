package com.example.careerguidancecenter.android.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.usecases.AnswerUseCase
import com.example.careerguidancecenter.android.domain.usecases.QuestionsUseCase
import com.example.careerguidancecenter.android.domain.usecases.SIgnInUseCase
import com.example.careerguidancecenter.android.domain.usecases.SIgnUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SIgnInUseCase,
    private val quest:QuestionsUseCase,
    private val ans:AnswerUseCase
) :ViewModel() {



    private var _errorLiveData = MutableLiveData<String>()
    var errorLiveData: LiveData<String> = _errorLiveData

    fun signIn(hashMap: HashMap<String,String>){
        viewModelScope.launch {
            val result = signInUseCase.execute(hashMap)
            when(result){
                is Resource.Error -> {
                    _errorLiveData.value = result.message!!
                    Log.i("LiveDataError", result.message)
                }
                is Resource.Success -> {
                    Log.d("Result", result.data.toString())
                }
            }
        }
    }
    fun q(token:String){
        viewModelScope.launch {
            val result = quest.execute(token)
            when(result){
                is Resource.Error -> {
                    _errorLiveData.value = result.message!!
                    Log.i("LiveDataError", result.message)
                }
                is Resource.Success -> {
                    Log.d("Result", result.data.toString())
                }
            }
        }
    }
    fun ansew(token:String,hashMap: HashMap<String,Any>){
        viewModelScope.launch {
            val result = ans.execute(hashMap,token)
            when(result){
                is Resource.Error -> {
                    _errorLiveData.value = result.message!!
                    Log.i("LiveDataError", result.message)
                }
                is Resource.Success -> {
                    Log.d("Result", result.data.toString())
                }
            }
        }
    }
}