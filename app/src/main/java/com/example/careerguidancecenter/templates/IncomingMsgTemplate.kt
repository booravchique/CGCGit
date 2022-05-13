package com.example.careerguidancecenter.templates

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.careerguidancecenter.templates.shape
import com.example.careerguidancecenter.ui.theme.*

val msgInc =
    "Что бы я хотел сделать полезного  для этого мира?  Какие идеи или проекты вы хотели бы реализовать? Даже самые фантастические."
val incomingMsgShape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp, bottomEnd = 15.dp)

@Preview
@Composable
fun IncomingMsgLayout() {
    Column(
        modifier = Modifier.padding(end = 60.dp, bottom = 8.dp)
    ){
        Box(
            modifier = Modifier
                .border(2.dp, BorderGray, shape = incomingMsgShape)
                .clip(incomingMsgShape)
                .background(White),
        ) {
            Text(
                modifier = Modifier
                    .padding(all = 8.dp),
                text = msgInc,
                color = DarkTextColor,
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                textAlign = TextAlign.Start
            )
        }
    }
}

//временно без тени

