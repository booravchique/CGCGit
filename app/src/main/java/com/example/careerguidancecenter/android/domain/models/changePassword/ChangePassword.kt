package com.example.careerguidancecenter.android.domain.models.changePassword

data class ChangePassword(
    val errors: List<Error>,
    val httpStatusCode: Int,
    val success: Boolean
)