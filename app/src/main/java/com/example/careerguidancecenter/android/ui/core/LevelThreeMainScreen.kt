package com.example.careerguidancecenter.android.ui.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.careerguidancecenter.android.ui.theme.*
import com.example.careerguidancecenter.android.R
import com.example.careerguidancecenter.android.ui.Nav

@Preview
@Composable
fun LevelThreeMainScreenLayout(
//    navController: NavHostController = rememberNavController()
) {
    val showInfo = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundFillGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (showInfo.value) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(540.dp)
                    .padding(all = 16.dp)
                    .border(1.dp, BorderGray, shape = shape)
                    .clip(shape)
                    .background(Color.White)
                    .clickable { showInfo.value = false },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier
                            .padding(bottom = 60.dp, start = 16.dp, end = 16.dp),
                        text = "Чем занимается блогер?",
                        fontFamily = RalewayFontFamily,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Black,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
                        text = """
                            На регулярной основе создает увлекательный контент для своего блога, используя различные инструменты социальных сетей
                            Монетизирует через продажу рекламы или собственных услуг
                            Выстраивает взаимодействие со своей целевой аудиторией
                        """.trimIndent(),
                        color = Color.Black,
                        fontFamily = RalewayFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start
                    )
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(540.dp)
                    .padding(all = 16.dp)
                    .border(1.dp, BorderGray, shape = shape)
                    .clip(shape)
                    .background(Color.White)
                    .clickable { showInfo.value = true },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier
                            .padding(bottom = 60.dp, start = 16.dp, end = 16.dp),
                        text = "Instagram или TikTok блогер",
                        fontFamily = RalewayFontFamily,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Black,
                        textAlign = TextAlign.Center
                    )
                    Image(
                        painter = painterResource(id = R.drawable.yourprofession),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillWidth,
                        alignment = Alignment.BottomEnd,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Box(
                    modifier = Modifier
                        .clickable { /*like*/ },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_like),
                        contentDescription = null,
                        tint = MainGray
                    )
                }
                Box(
                    modifier = Modifier
                        .clickable { /*dislike*/ },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_dislike),
                        contentDescription = null,
                        tint = MainGray
                    )
                }
            }
        }
    }
}