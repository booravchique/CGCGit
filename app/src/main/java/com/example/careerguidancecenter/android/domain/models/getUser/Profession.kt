package com.example.careerguidancecenter.android.domain.models.getUser

data class Profession(
    val cultureDescription: CultureDescription,
    val cultureLabel: CultureLabel,
    val id: Int,
    val linkSkills: List<Int>,
    val urlImage: String
)