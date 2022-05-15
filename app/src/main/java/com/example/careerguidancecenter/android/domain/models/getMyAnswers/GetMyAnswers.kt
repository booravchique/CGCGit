package com.example.careerguidancecenter.android.domain.models.getMyAnswers

data class GetMyAnswers(
    val errors: List<Error>,
    val httpStatusCode: Int,
    val success: Boolean,
    val value: List<Value>
)