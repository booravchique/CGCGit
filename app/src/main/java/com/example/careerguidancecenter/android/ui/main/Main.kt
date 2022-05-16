package com.example.careerguidancecenter.android.ui.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.layout.ContentScale.Companion.FillBounds
import androidx.compose.ui.layout.ContentScale.Companion.FillHeight
import androidx.compose.ui.layout.ContentScale.Companion.Fit
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.careerguidancecenter.android.R
import com.example.careerguidancecenter.android.ui.Nav
import com.example.careerguidancecenter.android.ui.core.*
import com.example.careerguidancecenter.android.ui.core.model.HintData
import com.example.careerguidancecenter.android.ui.main.model.Level
import com.example.careerguidancecenter.android.ui.setting.SettingsList
import com.example.careerguidancecenter.android.ui.setting.model.SettingType
import com.example.careerguidancecenter.android.ui.theme.*
import kotlinx.coroutines.delay


var Data = listOf(
    Level(
        Id = 1,
        HintData = HintData(
            Id = 1,
            Text = "Внимательно прочитайте вопросы и ответьте на них. Отвечайте честно, используя глаголы сделать, создать, разработать и т.д. " +
                    "Ответив на последний вопрос, еще раз внимательно прочитайте вопросы и ваши ответы. Найдите закономерности и сделайте обобщение, какие дела, настоящие и будущие вас захватывают?",
            TextBtn = "НАЧАТЬ",
            BtnBorderColor = MainCyan,
            BtnBackgroundColor = BorderCyan,
            FontSize = 28.sp,
            Link = Nav.QuestionLink.route
        ),
        LevelLabel = "Уровень 1",
        Name = "Самопознание",
        Background = MainCyan,
        BorderColor = BorderCyan,
        Image = R.drawable.ic_level1img,
        Link = ""
    ),
    Level(
        Id = 2,
        HintData = HintData(
            Id = 2,
            Text = "Внимательно изучите список умений, и выберите 5 умений, которые вам ближе всего. " +
                    "Выбери те 5 умений, которые попадают в самую точку и характеризуют именно вас.",
            TextBtn = "НАЧАТЬ",
            BtnBorderColor = BorderTurquoise,
            BtnBackgroundColor = MainTurquoise,
            FontSize = 32.sp,
            Link = Nav.ChoiceLink.route
        ),
        LevelLabel = "Уровень 2",
        Name = "Таланты",
        Background = MainTurquoise,
        BorderColor = BorderTurquoise,
        Image = R.drawable.ic_level2img,
        Link = ""
    ),
    Level(
        Id = 3,
        HintData = HintData(3, "","", Color.Transparent,Color.Transparent,0.sp,Nav.ProfessionsLink.route),
        LevelLabel = "Уровень 3",
        Name = "Профессии",
        Background = MainOrange,
        BorderColor = BorderOrange,
        Image = R.drawable.ic_level3img,
        Link = Nav.ProfessionsLink.route
    ),
    Level(
        Id = 4,
        HintData = null,
        LevelLabel = "Уровень 4",
        Name = "Твой выбор",
        Background = MainLightRed,
        BorderColor = BorderLightRed,
        Image = R.drawable.ic_level4img,
        Link = ""
    ),
)



@Composable
fun LevelsHeader(
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            modifier = Modifier,
            onClick = {
                navController.navigate(Nav.Settings.route)

            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            elevation = ButtonDefaults.elevation(0.dp),

            ) {
            Icon(
                painter = painterResource(id = R.drawable.settings_ic),
                contentDescription = null,
                tint = MainGray
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    val navController = rememberNavController()
    Column() {
        Column(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            LevelsHeader(navController)
        }
        LevelsSection(navController, Data)
    }

}

@Composable
fun LevelsSection(
    navController: NavHostController,
    level: List<Level>,
) {
    val shape = RoundedCornerShape(15.dp)
    LazyColumn(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
    ) {
        items(level.size) {
            OutlinedButton(
                onClick = {

                    navController.navigate("${Nav.LevelsLoad.route}/${level[it].Id}")
                },
                shape = shape,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.outlinedButtonColors(backgroundColor = level[it].Background),
                border = BorderStroke(2.dp, level[it].BorderColor),
                elevation = ButtonDefaults.elevation(10.dp),
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
                            text = level[it].LevelLabel,
                            color = Color.White,
                            fontFamily = RalewayFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,  //создать тайпографи
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 14.dp, top = 8.dp),
                            text = level[it].Name,
                            color = Color.White,
                            fontFamily = RalewayFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,  //создать тайпографи
                        )

                    }
                    Box(
                        modifier = Modifier.height(200.dp)
                    ) {
                        Image(
                            painter = painterResource(level[it].Image),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 40.dp),
                            contentScale = FillHeight,
                            alignment = Alignment.BottomEnd,
                        )
                    }
                }
            }
        }
    }
}
