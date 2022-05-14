package com.example.careerguidancecenter.android.ui.main.model

import androidx.compose.ui.graphics.Color
import com.example.careerguidancecenter.android.ui.core.model.HintData

data class Level(
    var Id: Int,
    var HintData: HintData?,
    val LevelLabel: String,
    val Name: String,
    val Background: Color,
    val BorderColor: Color,
    val Image: Int
)