package com.example.careerguidancecenter.android.ui.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.careerguidancecenter.android.ui.main.Data
import com.example.careerguidancecenter.android.ui.main.model.Level
import com.example.careerguidancecenter.android.ui.theme.MainOrange
import com.example.careerguidancecenter.android.ui.theme.RalewayFontFamily
import com.google.accompanist.systemuicontroller.SystemUiController


@Composable
fun LevelLoad(level:Level, systemUiController: SystemUiController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(level.Background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        systemUiController.setSystemBarsColor(
            color = level.Background,
        )
        LevelTextLayout(level.LevelLabel)
        LevelImageLayout(level.Image)
        LevelTextLayout(level.Name)
    }
}

@Composable
fun LevelTextLayout(
    text: String
) {
    Text(
        modifier = Modifier,
        text = text,
        color = Color.White,
        fontFamily = RalewayFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 38.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun LevelImageLayout(
    image: Int
) {
    Box(
        modifier = Modifier.height(250.dp)
    ){
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.Center,
        )
    }
}