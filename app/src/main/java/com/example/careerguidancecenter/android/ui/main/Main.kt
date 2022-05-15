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
import com.example.careerguidancecenter.android.ui.core.LevelHint
import com.example.careerguidancecenter.android.ui.core.LevelLoad
import com.example.careerguidancecenter.android.ui.core.LevelOneMainScreenLayout
import com.example.careerguidancecenter.android.ui.core.LevelTwoMainScreenLayout
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
        Image = R.drawable.selfknowledge,
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
        Image = R.drawable.talents,
    ),
    Level(
        Id = 3,
        HintData = null,
        LevelLabel = "Уровень 3",
        Name = "Профессии",
        Background = MainOrange,
        BorderColor = BorderOrange,
        Image = R.drawable.profs,
    ),
    Level(
        Id = 4,
        HintData = null,
        LevelLabel = "Уровень 4",
        Name = "Твой выбор",
        Background = MainLightRed,
        BorderColor = BorderLightRed,
        Image = R.drawable.yourchoice,
    ),
)


@Composable
fun LevelsLayoutScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Nav.Home.route) {
        composable(Nav.Home.route) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BackgroundFillGray)
            ) {
                LevelsHeader(navController)
                LevelsSection(navController, Data)
            }
        }
        composable(
            route = Nav.LevelsLoad.routeWithArgument,
            arguments = listOf(
                navArgument(Nav.LevelsLoad.argument0) { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val levelId =
                backStackEntry.arguments?.getInt(Nav.LevelsLoad.argument0) ?: return@composable
            val level = Data.filter { it.Id == levelId }.first()

            LaunchedEffect(key1 = true) {
                delay(3000L)
                navController.navigate("${Nav.Levels.route}/${levelId}")
            }

            LevelLoad(level = level)
        }
        composable(
            route = Nav.Levels.routeWithArgument,
            arguments = listOf(
                navArgument(Nav.Levels.argument0) { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val levelId =
                backStackEntry.arguments?.getInt(Nav.Levels.argument0) ?: return@composable
            val level = Data.filter { it.Id == levelId }.first()

            if (level.HintData != null) {
                LevelHint(level.HintData as HintData, navController);
            }
        }
        composable(route = Nav.Settings.routeWithArgument,
            arguments = listOf(
                navArgument(Nav.Settings.argument0) { type = NavType.IntType }
            )) { backStackEntry ->
            val settingId =
                backStackEntry.arguments?.getInt(Nav.Settings.argument0) ?: return@composable

            val settingEnum = SettingType.fromInt(settingId)
            if (settingEnum == SettingType.Language) {

            } else if (settingEnum == SettingType.Theme) {

            }
        }
        composable(Nav.Settings.route) {
            SettingsList(navController)
        }
        composable(Nav.QuestionLink.route) {
            LevelOneMainScreenLayout(navController)
        }

        composable(Nav.ChoiceLink.route) {
            LevelTwoMainScreenLayout(navController)
        }
    }
}


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
