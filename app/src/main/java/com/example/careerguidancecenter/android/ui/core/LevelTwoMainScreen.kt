package com.example.careerguidancecenter.android.ui.core

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.careerguidancecenter.android.R
import com.example.careerguidancecenter.android.ui.Nav
import com.example.careerguidancecenter.android.ui.core.model.LevelTwoQuestions
import com.example.careerguidancecenter.android.ui.core.model.Message
import com.example.careerguidancecenter.android.ui.theme.*


@Preview
@Composable
fun LevelTwoMainScreenLayout(
    navController: NavHostController = rememberNavController()
) {
    var count: MutableState<Int> = remember { mutableStateOf(0) }
    var showBtn: MutableState<Boolean> = remember { mutableStateOf(false) }
    if (count.value == 5) {
        showBtn.value = true
    } else {
        showBtn.value = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundFillGray)
            .padding(start = 16.dp, end = 16.dp)
    ) {
        LevelTwoMainScreenHeader(count, navController)
        Questions(count, showBtn)
        if (showBtn.value) ТextLevelButton(showBtn, navController)

    }
}

@Composable
fun ТextLevelButton(showBtn: MutableState<Boolean>, navController: NavHostController) {
    Row {
        OutlinedButton(
            onClick = {
                navController.navigate("${Nav.LevelsLoad.route}/3")
            },
            shape = shape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp, start = 10.dp)
                .border(1.dp, BorderTurquoise, shape = shape),
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MainTurquoise),
            contentPadding = PaddingValues(8.dp)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 6.dp),
                text = "Закончить",
                color = Color.White,
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Composable
fun LevelTwoMainScreenHeader(
    count: MutableState<Int>,
    navController: NavHostController
) {
    val constraints = ConstraintSet {
        val closeBtn = createRefFor("closeBtn")
        val restartBtn = createRefFor("restartBtn")
        val counting = createRefFor("counting")

        constrain(restartBtn) {
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
            top.linkTo(parent.top)
        }

        constrain(counting) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
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
            .padding(top = 8.dp, bottom = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .layoutId("restartBtn")
                .clickable { },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.restartbtn_ic),
                contentDescription = null,
                tint = MainGray
            )
        }
        Text(
            modifier = Modifier
                .layoutId("counting"),
            text = "Выбрано ${count.value}/5",
            fontFamily = RalewayFontFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Black
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
fun Questions(
    count: MutableState<Int>,
//    navController: NavHostController,
    showBtn: MutableState<Boolean>

) {
    var items by remember {
        mutableStateOf(
            LevelTwoQuestions().questions
        )
    }
    LazyColumn(
        modifier = if (showBtn.value) {
            Modifier.height(700.dp)
        } else {
            Modifier.fillMaxHeight()
        }
    ) {

        items(items.size + 1) { i ->
            if (i < items.size) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp)
                        .border(
                            2.dp,
                            if (items[i].isSelected) BorderTurquoise else BorderGray,
                            shape = shape
                        )
                        .clip(shape)
                        .background(if (items[i].isSelected) MainTurquoise else Color.White)
                        .clickable {
                            items = items.mapIndexed { j, item ->
                                if (i == j) {
                                    if (item.isSelected) {
                                        count.value--
                                        item.copy(isSelected = !item.isSelected)
                                    } else {
                                        if (count.value < 5) {
                                            count.value++
                                            item.copy(isSelected = !item.isSelected)
                                        } else {
                                            item
                                        }
                                    }
                                } else item
                            }

                            Log.d("asd", "count: $count")
                        },

                    ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(all = 8.dp),
                            text = items[i].question,
                            color = if (items[i].isSelected) White else DarkTextColor,
                            fontFamily = RalewayFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start
                        )
                    }
                }
            } else {
                if (count.value >= 5) {
//                    Row {
//                        OutlinedButton(
//                            onClick = {
//                                navController.navigate("${Nav.LevelsLoad.route}/3")
//                            },
//                            shape = shape,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(end = 10.dp, start = 10.dp)
//                                .border(1.dp, BorderTurquoise, shape = shape),
//                            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MainTurquoise),
//                            contentPadding = PaddingValues(8.dp)
//                        ) {
//                            Text(
//                                modifier = Modifier,
//                                text = "Закончить",
//                                color = Color.White,
//                                fontFamily = RalewayFontFamily,
//                                fontWeight = FontWeight.Bold,
//                                fontSize = 24.sp,
//                                textAlign = TextAlign.Center
//                            )
//                        }
//                    }
                }
            }
        }
    }
}
