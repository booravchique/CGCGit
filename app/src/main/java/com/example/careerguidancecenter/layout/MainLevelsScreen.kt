package com.example.careerguidancecenter.layout

import android.text.style.AlignmentSpan
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.material.ButtonDefaults.outlinedButtonColors
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.careerguidancecenter.R
import com.example.careerguidancecenter.model.Level
import com.example.careerguidancecenter.repository.LevelContent
import com.example.careerguidancecenter.ui.theme.RalewayFontFamily
import java.nio.file.Files.size

@Preview
@Composable
fun LevelsLayoutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
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
            modifier = Modifier
                .background(White),
            onClick = {},
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
                ){
                    Column(modifier = Modifier,
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
                    Image(
                        painter = painterResource(level[it].Image),
                        contentDescription = null,
                        modifier = Modifier.padding(top = 40.dp, start = 60.dp).size(150.dp),
                        contentScale = ContentScale.Crop
//                        alignment = Alignment.BottomEnd,

                    )
                }
            }
        }
    }
}