package com.example.careerguidancecenter.android.ui.core.model

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.careerguidancecenter.android.presentation.QuestionsViewModel
import com.example.careerguidancecenter.android.ui.core.shape
import com.example.careerguidancecenter.android.ui.theme.*
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util


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
    val context = LocalContext.current

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
    val video =
        "https://cdn.discordapp.com/attachments/783256831089836032/976141463735906354/file_example_MP4_480_1_5MG.mp4"
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
                            IncomingMsgLayout(msg, video, context)
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
    msg: String,
    video: String,
    context: Context

) {
    val exoPlayer = remember(context) {
        SimpleExoPlayer.Builder(context).build().apply {
            val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(
                context, Util.getUserAgent(context, context.packageName)
            )

            val source = ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(video))
            this.prepare(source)

        }
    }

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
            Column(
            ) {
                Text(
                    modifier = Modifier
                        .padding(bottom = 6.dp, start = 6.dp, end = 6.dp),
                    text = "asfasgetrbsrt4bubrubr6ubrd6udbr6ubert6ubdrtubr6ubrd6udbr6ubert6ubdrtubr6ubrd6udbr6ubert6ubdrtubr6ubrd6udbr6ubert6ubdrtubr6ubrd6udbr6ubert6ubdrtubr6ubrd6udbr6ubert6ubdrtubr6ubrd6udbr6ubert6ubdrtubr6ubrd6udbr6ubert6ubdrtubr6ubrd6udbr6ubert6ubdrt6ubrd6udbr6ubert6ubdrt6ubr6ubdr6ubdr6ub",
                    color = DarkTextColor,
                    fontFamily = RalewayFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start
                )
                Box(
                    modifier = Modifier.height(180.dp)
                ){
                    AndroidView(
                        factory = { context ->
                            PlayerView(context).apply {
                                player = exoPlayer
                            }
                        },
                        modifier = Modifier
                            .padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
                            .clip(shape)
                    )
                }
            }
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

