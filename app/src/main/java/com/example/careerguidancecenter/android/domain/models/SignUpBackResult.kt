package com.example.careerguidancecenter.android.domain.models

data class SignUpBackResult(
    val errors: List<Any>,
    val httpStatusCode: Int,
    val success: Boolean,
    val value: Value
)