package com.example.careerguidancecenter.android.presentation

import android.text.InputFilter
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careerguidancecenter.android.common.Resource
import com.example.careerguidancecenter.android.domain.models.getAllSkills.GetAllSkills
import com.example.careerguidancecenter.android.domain.models.getMySelectSkills.GetMySelectSkills
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
    val mySelectSkills = MutableLiveData<GetMySelectSkills>()
    val allSkills = MutableLiveData<GetAllSkills>()

    fun selectSkills(token:String,listSkills:List<Int>){
        viewModelScope.launch {
            val result = selectSkillsUseCase.execute(token,listSkills)
            when(result){
                is Resource.Error -> {
                    Log.i("LiveDataError", result.data.toString())
                }
                is Resource.Success -> {
                    Log.d("Result", result.data.toString())
                    selectLiveData.value = result.data
                }
            }
        }
    }

    fun getAllSkills(token:String){
        viewModelScope.launch {
            val result = getAllSkillsUseCase.execute(token)
            when(result){
                is Resource.Error -> {
                    Log.i("LiveDataError", result.data.toString())
                }
                is Resource.Success -> {
                    Log.d("Result", result.data.toString())
                    allSkills.value = result.data
                }
            }
        }
    }

    fun getMySkills(token:String){
        viewModelScope.launch {
            val result = getMySelectSkillsUseCase.execute(token)
            when(result){
                is Resource.Error -> {
                    Log.i("LiveDataError", result.data.toString())
                }
                is Resource.Success -> {
                    Log.d("Result", result.data.toString())
                    mySelectSkills.value = result.data
                }
            }
        }
    }
}