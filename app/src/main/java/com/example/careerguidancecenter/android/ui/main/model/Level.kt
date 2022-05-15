package com.example.careerguidancecenter.android.ui.main.model

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import com.example.careerguidancecenter.android.ui.core.model.HintData

data class Level(
    var Id: Int,
    var HintData: HintData?,
    val LevelLabel: String,
    val Name: String,
    val Background: Color,
    val BorderColor: Color,
    val Image: Int,
    val Link: String
)