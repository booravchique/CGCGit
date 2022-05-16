package com.example.careerguidancecenter.android.domain.models.getMySelectSkills

data class GetMySelectSkills(
    val errors: List<Error>,
    val httpStatusCode: Int,
    val success: Boolean,
    val value: List<Int>
)