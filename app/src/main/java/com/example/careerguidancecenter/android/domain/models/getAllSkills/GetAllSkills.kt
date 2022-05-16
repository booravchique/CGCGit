package com.example.careerguidancecenter.android.domain.models.getAllSkills

data class GetAllSkills(
    val errors: List<Error>,
    val httpStatusCode: Int,
    val success: Boolean,
    val value: List<Value>
)