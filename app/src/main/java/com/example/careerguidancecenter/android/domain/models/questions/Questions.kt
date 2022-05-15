package com.example.careerguidancecenter.android.domain.models.questions

data class Questions(
    val errors: List<Any>,
    val httpStatusCode: Int,
    val success: Boolean,
    val value: List<Value>
)