package com.example.careerguidancecenter.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.careerguidancecenter.R
import com.example.careerguidancecenter.templates.IncomingMsgLayout
import com.example.careerguidancecenter.templates.OutgoingMsgLayout
import com.example.careerguidancecenter.templates.shape
import com.example.careerguidancecenter.ui.theme.*

@Preview
@Composable
fun LevelOneMainScreenLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundFillGray)
            .padding(start = 16.dp, end = 16.dp)
    ) {
        LevelOneMainScreenHeader()
        IncomingMsgLayout()
        OutgoingMsgLayout()
    }
}

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
            .padding(top = 8.dp, bottom = 16.dp)
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
                .border(3.dp, BorderOrange, shape = shape)
                .clip(shape)
                .background(MainOrange)
                .layoutId("progressBar"),
        ) {

        }
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