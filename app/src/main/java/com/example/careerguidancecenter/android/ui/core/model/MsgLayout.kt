package com.example.careerguidancecenter.android.ui.core.model

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.careerguidancecenter.android.presentation.QuestionsViewModel
import com.example.careerguidancecenter.android.ui.theme.*


val incomingMsgShape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp, bottomEnd = 15.dp)
val outgoingMsgShape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp, bottomStart = 15.dp)


@Composable
fun Messages(
    fullCount: Int,
    progress: MutableState<Float>,
    questionsViewModel: QuestionsViewModel,
    message: MutableState<Message?>,
    isEnd: MutableState<Boolean>,
) {


    if (message.value != null) {

        Log.i("LiveDataError", questionsViewModel.questionsNotAnswer.toString())
        println("feffef")
        questionsViewModel.messages.add(message.value ?: Message(-1, "", true))

        questionsViewModel.questionsNotAnswer.remove(
            questionsViewModel.questionsNotAnswer.first { it.id == message.value?.id }
        )

        var questionsCount = questionsViewModel.questions.value?.value?.size ?: 1;
        progress.value += (1f / questionsCount)

        if (!questionsViewModel.questionsNotAnswer.any()) {
            isEnd.value = true
        } else {
            val next = questionsViewModel.questionsNotAnswer.first()
            questionsViewModel.messages.add(Message(next.id, next.cultureLabel.text, false))

            message.value = null

        }
    }
    println("fefhuefheff")
    Box(
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(bottom = 60.dp),
            ) {

                items(questionsViewModel.messages.size) {
                    Row(
                        modifier = Modifier
                            .weight(1f, false)
                    ) {
                        val msg = questionsViewModel.messages[it].content
                        if (questionsViewModel.messages[it].isAnswer == false) {
                            IncomingMsgLayout(msg)
                        } else {
                            OutgoingMsgLayout(msg)
                        }
                    }

                }
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
                .border(1.dp, BorderGray, shape = incomingMsgShape)
                .clip(incomingMsgShape)
                .background(Color.White),
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 6.dp, start = 6.dp, end = 6.dp),
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
                .border(1.dp, BorderCyan, shape = outgoingMsgShape)
                .clip(outgoingMsgShape)
                .background(MainCyan)
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 6.dp, start = 6.dp, end = 6.dp),
                text = msg,
                color = White,
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                textAlign = TextAlign.Start
            )
        }
    }
}

