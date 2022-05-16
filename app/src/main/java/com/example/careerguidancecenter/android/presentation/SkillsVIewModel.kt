package com.example.careerguidancecenter.android.presentation

import android.text.InputFilter
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.selectSkills.SelectSkills
import com.example.careerguidancecenter.android.domain.usecases.GetAllSkillsUseCase
import com.example.careerguidancecenter.android.domain.usecases.GetMySelectSkillsUseCase
import com.example.careerguidancecenter.android.domain.usecases.SelectSkillsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SkillsVIewModel
    @Inject constructor(
        private val getMySelectSkillsUseCase: GetMySelectSkillsUseCase,
        private val selectSkillsUseCase: SelectSkillsUseCase,
        private val getAllSkillsUseCase: GetAllSkillsUseCase
    ):ViewModel(){


    val selectLiveData = MutableLiveData<SelectSkills>()
    val mySelectSkills = MutableLiveData<String>()
    val allSkills = MutableLiveData<GetAllSkillsUseCase>()

    var errorLiveData = MutableLiveData<String>()

        fun selectSkills(token:String,listSkills:MutableList<Int>){
            viewModelScope.launch {
                val result = selectSkillsUseCase.execute(token,listSkills)
                when(result){
                    is Resource.Error -> {
                        errorLiveData.value = result.message!!
                        Log.i("LiveDataError", result.message)
                        Log.i("LiveDataError", result.data.toString())
                    }
                    is Resource.Success -> {
                        Log.d("Result", result.data.toString())
                        selectLiveData.value = result.data
                    }
                }
            }
        }
}