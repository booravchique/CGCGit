package com.example.careerguidancecenter.android.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.usecases.AnswerUseCase
import com.example.careerguidancecenter.android.domain.usecases.GetMyAnswersUseCase
import com.example.careerguidancecenter.android.domain.usecases.QuestionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel
    @Inject constructor(
        private val questionsUseCase: QuestionsUseCase,
        private val answerUseCase: AnswerUseCase,
        private val getMyAnswersUseCase: GetMyAnswersUseCase
    ):ViewModel() {
    val result2 = MutableLiveData<String>()
    val result3 = MutableLiveData<String>()
    val result4 = MutableLiveData<String>()

    private var _errorLiveData = MutableLiveData<String>()
    var errorLiveData: LiveData<String> = _errorLiveData


    fun getQuestions(token:String){
        viewModelScope.launch {
            val result = questionsUseCase.execute(token)
            when(result){
                is Resource.Error -> {
                    _errorLiveData.value = result.message!!
                    Log.i("LiveDataError", result.message)
                }
                is Resource.Success -> {
                    Log.d("Result", result.data.toString())
                    result2.value = result.data?.value.toString()
                }
            }
        }
    }

    fun postAnswer(token:String,hashMap: HashMap<String,Any>){
        viewModelScope.launch {
            val result = answerUseCase.execute(hashMap,token)
            when(result){
                is Resource.Error -> {
                    _errorLiveData.value = result.message!!
                    Log.i("LiveDataError", result.message)
                }
                is Resource.Success -> {
                    Log.d("Result", result.data.toString())
                    result3.value = result.data?.success.toString()
                }
            }
        }
    }
    fun getAnswers(token:String){
        viewModelScope.launch {
            val result = getMyAnswersUseCase.execute(token)
            when(result){
                is Resource.Error -> {
                    _errorLiveData.value = result.message!!
                    Log.i("LiveDataError", result.message)
                }
                is Resource.Success -> {
                    Log.d("Result", result.data.toString())
                    result4.value = result.data?.toString()
                }
            }
        }
    }
}