package com.example.careerguidancecenter.templates

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.careerguidancecenter.ui.theme.*

val outMsg = "Lorem ipsum dolor sit amet, consectetur adipiscing elit ut"

val outgoingMsgShape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp, bottomStart = 15.dp)

@Preview
@Composable
fun OutgoingMsgLayout() {
    Column(
        modifier = Modifier.padding(start = 60.dp, bottom = 8.dp)
    ){
        Box(
            modifier = Modifier
                .border(2.dp, BorderOrange, shape = outgoingMsgShape)
                .clip(outgoingMsgShape)
                .background(MainOrange)
        ) {
            Text(
                modifier = Modifier
                    .padding(all = 8.dp),
                text = outMsg,
                color = DarkTextColor,
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                textAlign = TextAlign.Start
            )
        }
    }

}