package com.example.careerguidancecenter.android.domain.models.getUser

data class Value(
    val fullName: String,
    val id: Int,
    val isAdmin: Boolean,
    val isoCode: String,
    val profession: Profession
)