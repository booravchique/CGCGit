package com.example.careerguidancecenter.android.ui.core.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit

data class HintData(
    var Id: Int,
    var Text: String,
    var TextBtn: String,
    var BtnBorderColor: Color,
    var BtnBackgroundColor: Color,
    var FontSize: TextUnit
)