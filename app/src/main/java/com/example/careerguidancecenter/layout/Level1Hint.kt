package com.example.careerguidancecenter.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.careerguidancecenter.templates.HintLayout
import com.example.careerguidancecenter.ui.theme.*

@Preview
@Composable
fun LevelOneHintLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundFillGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HintLayout(
            text = "Внимательно прочитайте вопросы и ответьте на них. Отвечайте честно, используя глаголы сделать, создать, разработать и т.д. " +
            "Ответив на последний вопрос, еще раз внимательно прочитайте вопросы и ваши ответы. Найдите закономерности и сделайте обобщение, какие дела, настоящие и будущие вас захватывают?",
            textBtn = "НАЧАТЬ",
            btnBorderColor = BorderOrange,
            btnBackgroundColor = BorderBlue,
            fontSize = 28.sp
        )
    }
}

