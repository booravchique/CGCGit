package com.example.careerguidancecenter.android.domain.models.answer

data class Answers(
    val errors: List<Error>,
    val httpStatusCode: Int,
    val success: Boolean
)