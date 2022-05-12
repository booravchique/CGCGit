package com.example.careerguidancecenter.templates

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
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
import com.example.careerguidancecenter.ui.theme.MainGray
import com.example.careerguidancecenter.ui.theme.RalewayFontFamily

val shape = RoundedCornerShape(15.dp)

@Composable
fun HintLayout(
    text: String,
    textBtn: String,
    btnBorderColor: Color,
    btnBackgroundColor: Color,
    fontSize: TextUnit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
            .border(3.dp, MainGray, shape = shape)
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
                text = text,
                color = Color.Black,
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = fontSize,
                textAlign = TextAlign.Start
            )
            DefaultButton(
                textBtn = textBtn,
                btnBorderColor = btnBorderColor,
                btnBackgroundColor = btnBackgroundColor
            )
        }
    }
}

@Composable
fun DefaultButton(
    textBtn: String,
    btnBorderColor: Color,
    btnBackgroundColor: Color
) {
    OutlinedButton(
        onClick = {},
        shape = shape,
        modifier = Modifier
            .fillMaxWidth()
            .border(3.dp, btnBorderColor, shape = shape),
        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = btnBackgroundColor),
        contentPadding = PaddingValues(8.dp)
    ) {
        Text(
            modifier = Modifier,
            text = textBtn,
            color = Color.White,
            fontFamily = RalewayFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 38.sp,
            textAlign = TextAlign.Center
        )
    }
}