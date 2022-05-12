package com.example.careerguidancecenter.layout


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.careerguidancecenter.R
import com.example.careerguidancecenter.templates.LevelImageLayout
import com.example.careerguidancecenter.templates.LevelTextLayout
import com.example.careerguidancecenter.ui.theme.MainOrange


@Preview
@Composable
fun LevelOneLoadingLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainOrange),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        LevelTextLayout("Уровень 1")
        LevelImageLayout(image = R.drawable.thoughtsfull)
        LevelTextLayout("Мысли")
    }
}

