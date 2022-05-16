package com.example.careerguidancecenter.android.ui.core

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.careerguidancecenter.android.ui.theme.RalewayFontFamily

@Composable
fun DefaultButton(
    textBtn: String,
    btnBorderColor: Color,
    btnBackgroundColor: Color,
    navController: NavHostController,
    link: String

) {
    OutlinedButton(
        onClick = {
                  navController.navigate(link)
        },
        shape = shape,
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, btnBorderColor, shape = shape),
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