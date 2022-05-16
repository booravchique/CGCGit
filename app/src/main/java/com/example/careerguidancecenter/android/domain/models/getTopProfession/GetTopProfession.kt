package com.example.careerguidancecenter.android.domain.models.getTopProfession

data class GetTopProfession(
    val errors: List<Error>,
    val httpStatusCode: Int,
    val success: Boolean,
    val value: List<Value>
)