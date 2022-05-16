package com.example.careerguidancecenter.android.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.careerguidancecenter.android.R
import com.example.careerguidancecenter.android.Token
import com.example.careerguidancecenter.android.domain.models.questions.Questions
import com.example.careerguidancecenter.android.presentation.QuestionsViewModel
import com.example.careerguidancecenter.android.ui.Nav
import com.example.careerguidancecenter.android.ui.core.model.LevelTwoQuestions
import com.example.careerguidancecenter.android.ui.core.model.Message
import com.example.careerguidancecenter.android.ui.core.model.Messages
import com.example.careerguidancecenter.android.ui.theme.*
import com.example.careerguidancecenter.android.Token


@Composable
fun LevelOneMainScreenLayout(
    navController: NavHostController,
    questionsViewModel: QuestionsViewModel
) {

    var questions by remember {
        mutableStateOf(
            questionsViewModel.questions
        )
    }
    questionsViewModel.getQuestions(Token ?: "")


    var answers by remember {
        mutableStateOf(
            questionsViewModel.answers
        )
    }
    questionsViewModel.getAnswers(Token ?: "")

    if (answers.value == null || answers.value == null)
        return

    val listMessages: MutableList<Message> = mutableListOf()
    answers.value?.value?.map {
        val qId = it.questionId
        val question = questions.value?.value?.first { it.id == qId }

        listMessages.add(Message(qId, question?.cultureLabel?.text ?: "", false))
        listMessages.add(Message(qId, it.content, true))
    }

    var questionsNotAnswers = questions.value?.value?.filter {
        val qId = it.id
        !listMessages.any { it.id == qId && !it.isAnswer }
    }?.sortedBy { it.id }

    var message: MutableState<Message?> = remember { mutableStateOf(null) }
    var isEnd: MutableState<Boolean> = remember { mutableStateOf(false) }

    var questionsCount = questions.value?.value?.size ?: 1;
    var questionsNotAnswersCount = questionsNotAnswers?.size ?: 0
    var progress: MutableState<Float> = remember {
        mutableStateOf((1f / questionsCount) * (questionsCount - questionsNotAnswersCount))
    }

    if (!(questionsNotAnswers?.any() ?: false)) {
        isEnd.value = true
    } else {
        var next = questionsNotAnswers?.first()!!
        listMessages.add(Message(next.id, next.cultureLabel.text, false))
    }
    questionsViewModel.setQuestionsNotAnswer(questionsNotAnswers ?: listOf())

    questionsViewModel.messages.clear()
    questionsViewModel.messages.addAll(listMessages)
    println("FIEFGEIFUV")

    val constraints = ConstraintSet {
        val firstChild = createRefFor("firstChild")
        val middleChild = createRefFor("middleChild")
        val lastChild = createRefFor("lastChild")

        constrain(firstChild) {
            top.linkTo(parent.top)
            bottom.linkTo(middleChild.top)
        }
        constrain(middleChild) {
            top.linkTo(firstChild.bottom)
        }
        constrain(lastChild) {
            bottom.linkTo(parent.bottom)
        }
    }
    ConstraintLayout(
        constraints,
        modifier = Modifier
            .background(BackgroundFillGray)
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundFillGray)
                .layoutId("firstChild")
        ) {
            LevelOneMainScreenHeader(
                progress,
                navController
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 60.dp)
                .background(BackgroundFillGray)
                .layoutId("middleChild")
                .scrollable(rememberScrollState(), orientation = Orientation.Vertical)
        ) {
            Messages(questionsCount, progress, questionsViewModel, message, isEnd)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundFillGray)
                .layoutId("lastChild")
        ) {
            LevelOneTextField(message, questionsViewModel, isEnd, navController)
        }
    }
}
//    ConstraintLayout(constraints){
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(BackgroundFillGray)
//                .padding(start = 16.dp, end = 16.dp)
//                .layoutId("firstChild")
//        ) {
//            LevelOneMainScreenHeader()
////            Messages(msgInc = MsgContent().msgs)
//        }
//        Row(
//            modifier = Modifier.layoutId("lastChild").background(BackgroundFillGray)
//        ){
//            LevelOneTextField()
//        }
//    }
//}

@Composable
fun LevelOneMainScreenHeader(
    progress: MutableState<Float>,
    navController: NavHostController,
) {
    var showAlertDialog = remember { mutableStateOf(false) }
    val constraints = ConstraintSet {
        val closeBtn = createRefFor("closeBtn")
        val restartBtn = createRefFor("restartBtn")
        val progressBar = createRefFor("progressBar")

        constrain(restartBtn) {
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
            top.linkTo(parent.top)
        }

        constrain(progressBar) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            top.linkTo(parent.top)
        }

        constrain(closeBtn) {
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            top.linkTo(parent.top)
        }

    }
    ConstraintLayout(
        constraints,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .layoutId("restartBtn")
                .clickable { showAlertDialog.value = true },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.restartbtn_ic),
                contentDescription = null,
                tint = MainGray
            )
        }
        LinearProgressIndicator(
            progress = progress.value,
            modifier = Modifier
                .size(width = 210.dp, height = 35.dp)
                .border(0.dp, Color.Transparent, shape = shape)
                .clip(shape)
                .background(Color.Transparent)
                .layoutId("progressBar"),
            color = MainCyan
        )

        Box(
            modifier = Modifier
                .layoutId("closeBtn")
                .clickable { navController.navigate(Nav.Home.route) },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.closebtn_ic),
                contentDescription = null,
                tint = MainGray
            )
        }
    }
}

@Composable
fun LevelOneTextField(
    message: MutableState<Message?>,
    questionsViewModel: QuestionsViewModel,
    isEnd: MutableState<Boolean>,
    navController: NavHostController,
) {

    var answer = remember { mutableStateOf("") }


    fun sendMessage() {
        val hashMap: HashMap<String, Any> = hashMapOf()
        hashMap.put("questionId", questionsViewModel.messages.last().id)
        hashMap.put("content", answer.value)
        questionsViewModel.postAnswer(Token ?: "", hashMap)


        message.value = Message(questionsViewModel.messages.last().id, answer.value, true)
        answer.value = ""
    }


    Row {

        if (isEnd.value) {
            OutlinedButton(
                onClick = {
                    navController.navigate("${Nav.LevelsLoad.route}/2")
                },
                shape = shape,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
                    .border(1.dp, BorderTurquoise, shape = shape),
                colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MainTurquoise),
                contentPadding = PaddingValues(8.dp)
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 4.dp),
                    text = "Закончить",
                    color = Color.White,
                    fontFamily = RalewayFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }

        } else {
            TextField(
                modifier = Modifier.weight(1f),
                value = answer.value,
                onValueChange = { answer.value = it },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                keyboardActions = KeyboardActions {
                    sendMessage()
                },
                placeholder = { Text("Введите ваш ответ") },
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = BorderCyan,
                    unfocusedBorderColor = BorderGray,
                    backgroundColor = Color.White
                )
            )
            Button(
                modifier = Modifier.height(56.dp),
                onClick = { sendMessage() },
                enabled = answer.value.isNotBlank(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_sendmsg),
                    contentDescription = null
                )
            }
        }
    }
}


@Composable
fun modalView(
    showAlertDialog: MutableState<Boolean>
) {
    if (showAlertDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showAlertDialog.value = false
            },
            title = {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = 14.dp, top = 8.dp),
                        text = "Весь прогресс будет сброшен",
                        color = DarkTextColor,
                        fontFamily = RalewayFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 14.dp, top = 8.dp),
                        text = "Продолжить?",
                        color = DarkTextColor,
                        fontFamily = RalewayFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                }
            },
            buttons = {
                Row(
                    modifier = Modifier
                        .padding(all = 8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        modifier = Modifier,
                        onClick = { showAlertDialog.value = false },
                        colors = ButtonDefaults.buttonColors(backgroundColor = MainCyan)
                    ) {
                        Text(
                            modifier = Modifier,
                            text = "Назад",
                            color = White,
                            fontFamily = RalewayFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Button(
                        modifier = Modifier,
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(backgroundColor = MainCyan)
                    ) {
                        Text(
                            modifier = Modifier,
                            text = "Сброс",
                            color = White,
                            fontFamily = RalewayFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            },
            backgroundColor = White
        )
    }
}
