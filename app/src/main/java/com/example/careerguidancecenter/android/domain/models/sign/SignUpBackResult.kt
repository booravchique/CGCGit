package com.example.careerguidancecenter.android.domain.models.sign

data class SignUpBackResult(
    val errors: List<Error>,
    val httpStatusCode: Int,
    val success: Boolean,
    val value: Value
)

data class Error(
    val name: String,
    val description: String
)