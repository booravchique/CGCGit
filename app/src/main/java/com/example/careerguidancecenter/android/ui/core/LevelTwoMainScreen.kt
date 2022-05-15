package com.example.careerguidancecenter.android.ui.core

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.careerguidancecenter.android.R
import com.example.careerguidancecenter.android.ui.core.model.LevelTwoQuestions
import com.example.careerguidancecenter.android.ui.theme.*


@Composable
fun LevelTwoMainScreenLayout(
    navController: NavHostController
) {
    var count: Int = Questions()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundFillGray)
            .padding(start = 16.dp, end = 16.dp)
    ) {
        LevelTwoMainScreenHeader()
        Questions()
    }
}


@Composable
fun LevelTwoMainScreenHeader(

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
        Button(
            modifier = Modifier
                .layoutId("restartBtn"),
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            elevation = ButtonDefaults.elevation(0.dp),
            contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),


            ) {
            Icon(
                modifier = Modifier
                    .padding(all = 0.dp),
                painter = painterResource(id = R.drawable.restartbtn_ic),
                contentDescription = null,
                tint = MainGray
            )
        }
        Text(
            modifier = Modifier
                .layoutId("counting"),
            text = "Выбрано 5/5",
            fontFamily = RalewayFontFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = DarkTextColor
        )
        Button(
            modifier = Modifier.layoutId("closeBtn"),
            onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            elevation = ButtonDefaults.elevation(0.dp),

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
fun Questions(): Int {

    var items by remember {
        mutableStateOf(
            LevelTwoQuestions().questions
        )
    }

    var count by remember {
        mutableStateOf(0)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {

        items(items.size) { i ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
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
                                item.copy(isSelected = !item.isSelected)

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
                        color = DarkTextColor,
                        fontFamily = RalewayFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
    count = items.count {it.isSelected}
    return count
}
