package com.example.careerguidancecenter.android.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.careerguidancecenter.android.R
import com.example.careerguidancecenter.android.ui.core.model.Messages
import com.example.careerguidancecenter.android.ui.core.model.MsgContent
import com.example.careerguidancecenter.android.ui.theme.*

@Preview
@Composable
fun LevelOneMainScreenLayout(
//    navController: NavHostController
) {
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
    ConstraintLayout(constraints) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundFillGray)
                .layoutId("firstChild")
        ) {
            LevelOneMainScreenHeader()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 60.dp)
                .background(BackgroundFillGray)
                .layoutId("middleChild")
                .scrollable(rememberScrollState(), orientation = Orientation.Vertical)
        ) {
            Messages(msgInc = MsgContent().msgs)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundFillGray)
                .layoutId("lastChild")
        ){
            LevelOneTextField()
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
fun LevelOneMainScreenHeader() {
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
            .padding(top = 8.dp, bottom = 8.dp)
    ) {
        Button(
            modifier = Modifier
                .layoutId("restartBtn"),
            onClick = {},
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
        Box(
            modifier = Modifier
                .size(width = 210.dp, height = 30.dp)
                .border(3.dp, BorderCyan, shape = shape)
                .clip(shape)
                .background(MainCyan)
                .layoutId("progressBar"),
        ) {

        }
        Button(
            modifier = Modifier.layoutId("closeBtn"),
            onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            elevation = ButtonDefaults.elevation(0.dp),
            contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),
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
fun LevelOneTextField() {

    var answer = remember { mutableStateOf("") }

    TextField(
        value = answer.value,
        trailingIcon = {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_sendmsg),
                    contentDescription = null,
                    tint = MainGray
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        onValueChange = { answer.value = it },
        placeholder = { Text("Введите ваш ответ") },
        singleLine = true,
        shape = shape,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = BorderCyan,
            unfocusedBorderColor = BorderGray,
            backgroundColor = Color.White
        ),
    )
}
