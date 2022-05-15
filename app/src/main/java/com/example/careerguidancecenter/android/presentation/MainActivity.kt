package com.example.careerguidancecenter.android.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.careerguidancecenter.android.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: SignInViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hashMap:HashMap<String,String> = hashMapOf()
        hashMap.put("email","e@fsdfs.ru")
        hashMap.put("password","eee-gdfg43Ae")
        viewModel.signIn(hashMap)
        viewModel.q("7741b563-fcd5-4c79-8f6c-e6868b1b7fcf")
        val hashMap2:HashMap<String,Any> = hashMapOf()
        hashMap2.put("id",1)
        hashMap2.put("questionId",1)
        hashMap2.put("jsonData","string")
        viewModel.ansew(hashMap = hashMap2, token = "7741b563-fcd5-4c79-8f6c-e6868b1b7fcf")
    }
}