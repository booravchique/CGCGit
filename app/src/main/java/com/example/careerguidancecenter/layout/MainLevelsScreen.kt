package com.example.careerguidancecenter.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.material.ButtonDefaults.outlinedButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.careerguidancecenter.R
import com.example.careerguidancecenter.model.Level
import com.example.careerguidancecenter.repository.LevelContent
import com.example.careerguidancecenter.ui.theme.BackgroundFillGray
import com.example.careerguidancecenter.ui.theme.RalewayFontFamily


@Preview
@Composable
fun LevelsLayoutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundFillGray)
    ) {
        LevelsHeader()
        LevelsSection(level = LevelContent().ListLevels)
    }
}

@Composable
fun LevelsHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            modifier = Modifier,
            onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            elevation = ButtonDefaults.elevation(0.dp),

            ) {
            Icon(
                painter = painterResource(id = R.drawable.settings_ic),
                contentDescription = null,
            )
        }
    }
}

@Composable
fun LevelsSection(
    level: List<Level>
) {
    val shape = RoundedCornerShape(15.dp)
    LazyColumn(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
    ) {
        items(level.size) {
            OutlinedButton(
                onClick = {},
                shape = shape,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(),
                colors = outlinedButtonColors(backgroundColor = level[it].Background),
                border = BorderStroke(2.dp, level[it].BorderColor),
                elevation = elevation(10.dp),
                contentPadding = PaddingValues(0.dp)

            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(start = 14.dp, top = 8.dp),
                            text = level[it].Level,
                            color = White,
                            fontFamily = RalewayFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,  //создать тайпографи
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 14.dp, top = 8.dp),
                            text = level[it].Name,
                            color = White,
                            fontFamily = RalewayFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,  //создать тайпографи
                        )
                    }
                    Box(
                        modifier = Modifier.height(200.dp)
                    ) {
                        Image(
                            painter = painterResource(level[it].Image),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 40.dp)
                                .fillMaxSize(),
                            contentScale = ContentScale.FillHeight,
                            alignment = Alignment.BottomEnd,
                        )
                    }
                }
            }
        }
    }
}