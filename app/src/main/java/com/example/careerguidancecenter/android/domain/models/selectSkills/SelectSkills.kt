package com.example.careerguidancecenter.android.domain.models.selectSkills

data class SelectSkills(
    val errors: List<Error>,
    val httpStatusCode: Int,
    val success: Boolean
)