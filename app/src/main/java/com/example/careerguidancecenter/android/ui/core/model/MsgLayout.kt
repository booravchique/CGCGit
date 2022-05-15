package com.example.careerguidancecenter.android.ui.core.model

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.careerguidancecenter.android.ui.theme.*


val incomingMsgShape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp, bottomEnd = 15.dp)
val outgoingMsgShape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp, bottomStart = 15.dp)

@Preview
@Composable
fun Preview() {
    Messages(
        msgInc = MsgContent().msgs
    )
}

@Composable
fun Messages(
    msgInc: List<Messages>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 60.dp, start = 8.dp, end = 8.dp),
    ) {
        items(msgInc.size) {
            val msg = msgInc[it].content
            if (msgInc[it].classification == false) {
                IncomingMsgLayout(msg)
            } else {
                OutgoingMsgLayout(msg)
            }
        }
    }
}

@Composable
fun IncomingMsgLayout(
    msg: String
) {
    Column(
        modifier = Modifier
            .padding(end = 60.dp, bottom = 8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .border(2.dp, BorderGray, shape = incomingMsgShape)
                .clip(incomingMsgShape)
                .background(Color.White),
        ) {
            Text(
                modifier = Modifier
                    .padding(all = 8.dp),
                text = msg,
                color = DarkTextColor,
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                textAlign = TextAlign.Start
            )
        }
    }

}

@Composable
fun OutgoingMsgLayout(
    msg: String
) {
    Column(
        modifier = Modifier
            .padding(start = 60.dp, bottom = 8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        Box(
            modifier = Modifier
                .border(2.dp, BorderCyan, shape = outgoingMsgShape)
                .clip(outgoingMsgShape)
                .background(MainCyan)
        ) {
            Text(
                modifier = Modifier
                    .padding(all = 8.dp),
                text = msg,
                color = DarkTextColor,
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                textAlign = TextAlign.Start
            )
        }
    }
}

