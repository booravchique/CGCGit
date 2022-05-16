package com.example.careerguidancecenter.android.domain.models.getTopProfession

data class Value(
    val cultureDescription: CultureDescription,
    val cultureLabel: CultureLabel,
    val id: Int,
    val linkSkills: List<Int>,
    val urlImage: String
)