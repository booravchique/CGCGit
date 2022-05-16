package com.example.careerguidancecenter.android.domain.models.getUser

data class GetUser(
    val errors: List<Error>,
    val httpStatusCode: Int,
    val success: Boolean,
    val value: Value
)