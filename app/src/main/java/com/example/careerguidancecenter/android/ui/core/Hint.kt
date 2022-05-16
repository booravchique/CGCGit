package com.example.careerguidancecenter.android.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.careerguidancecenter.android.ui.core.model.HintData
import com.example.careerguidancecenter.android.ui.theme.*



@Composable
fun LevelHint(
    data: HintData,
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundFillGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Hint(data, navController)
    }
}

val shape = RoundedCornerShape(15.dp)

@Composable
private fun Hint(
    data: HintData,
    navController: NavHostController,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
            .border(1.dp, MainGray, shape = shape)
            .clip(shape)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                text = data.Text,
                color = Color.Black,
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = data.FontSize,
                textAlign = TextAlign.Start
            )
            DefaultButton(
                textBtn = data.TextBtn,
                btnBorderColor = data.BtnBorderColor,
                btnBackgroundColor = data.BtnBackgroundColor,
                navController = navController,
                link = data.Link
            )
        }
    }
}