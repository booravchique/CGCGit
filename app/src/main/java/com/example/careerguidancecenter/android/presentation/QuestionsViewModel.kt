package com.example.careerguidancecenter.android.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.answer.Answers
import com.example.careerguidancecenter.android.domain.models.getMyAnswers.GetMyAnswers
import com.example.careerguidancecenter.android.domain.models.questions.Questions
import com.example.careerguidancecenter.android.domain.models.questions.Value
import com.example.careerguidancecenter.android.domain.usecases.AnswerUseCase
import com.example.careerguidancecenter.android.domain.usecases.GetMyAnswersUseCase
import com.example.careerguidancecenter.android.domain.usecases.QuestionsUseCase
import com.example.careerguidancecenter.android.ui.core.model.Message
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
    val questions = MutableLiveData<Questions?>()
    val answers = MutableLiveData<GetMyAnswers?>()


    val messages: MutableList<Message> = mutableListOf()

    val questionsNotAnswer: MutableList<Value> = mutableListOf()

    fun setQuestionsNotAnswer(qufestionsNotAnswer: List<Value>){
        questionsNotAnswer.clear()
        questionsNotAnswer.addAll(qufestionsNotAnswer)
    }
    private var _errorLiveData = MutableLiveData<String>()
    var errorLiveData: LiveData<String> = _errorLiveData


    fun getQuestions(token:String){
        viewModelScope.launch {
            val result = questionsUseCase.execute(token)
            when(result){
                is Resource.Error -> {
                    questions.value = result.data
                    _errorLiveData.value = result.message!!
                    Log.i("LiveDataError", result.message)
                }
                is Resource.Success -> {
                    Log.d("Result", result.data.toString())
                    questions.value = result.data
                }
            }
        }
    }

    val answer = MutableLiveData<Answers?>()

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
                    answer.value = result.data
                }
            }
        }
    }
    fun getAnswers(token:String){
        viewModelScope.launch {
            val result = getMyAnswersUseCase.execute(token)
            when(result){
                is Resource.Error -> {
                    answers.value = result.data
                    _errorLiveData.value = result.message!!
                    Log.i("LiveDataError", result.message)
                }
                is Resource.Success -> {
                    Log.d("Result", result.data.toString())
                    answers.value = result.data
                }
            }
        }
    }
}