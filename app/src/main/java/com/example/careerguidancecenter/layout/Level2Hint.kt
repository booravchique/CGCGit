package com.example.careerguidancecenter.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.careerguidancecenter.templates.HintLayout
import com.example.careerguidancecenter.ui.theme.BackgroundFillGray
import com.example.careerguidancecenter.ui.theme.BorderBlue
import com.example.careerguidancecenter.ui.theme.BorderOrange
import com.example.careerguidancecenter.ui.theme.MainBlue

@Preview
@Composable
fun LevelTwoHintLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundFillGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HintLayout(
            text = "Внимательно изучите список умений, и выберите 5 умений, которые вам ближе всего. " +
                    "Выбери те 5 умений, которые попадают в самую точку и характеризуют именно вас.",
            textBtn = "НАЧАТЬ",
            btnBorderColor = BorderBlue,
            btnBackgroundColor = MainBlue,
            fontSize = 32.sp
        )
    }
}