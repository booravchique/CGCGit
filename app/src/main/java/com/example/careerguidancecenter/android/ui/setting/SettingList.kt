package com.example.careerguidancecenter.android.ui.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.careerguidancecenter.android.ui.setting.model.SettingItem
import com.example.careerguidancecenter.android.ui.theme.BackgroundFillGray
import com.example.careerguidancecenter.android.ui.theme.MainGray
import com.example.careerguidancecenter.android.ui.theme.RalewayFontFamily
import com.example.careerguidancecenter.android.R
import com.example.careerguidancecenter.android.ui.Nav
import com.example.careerguidancecenter.android.ui.setting.model.SettingType
import javax.net.ssl.HostnameVerifier

@Composable
fun SettingsList(
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            SettingsHeader(navController)
            SettingsSection(navController, listOf(
                SettingItem(SettingType.Language, R.drawable.lang_ic, "Язык"),
                SettingItem(SettingType.Theme, R.drawable.sun_ic, "Цветовая тема")
            ))
        }

        AppVersion()
    }
}

@Composable
fun SettingsHeader(
    navController: NavHostController
) {
    val constraints = ConstraintSet {
        val settingText = createRefFor("settingText")
        val backButton = createRefFor("backButton")

        constrain(settingText) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(backButton) {
            start.linkTo(parent.start)
        }
    }
    ConstraintLayout(constraints, modifier = Modifier.fillMaxWidth()) {
        Button(
            modifier = Modifier.layoutId("backButton"),
            onClick = {
                navController.navigate(Nav.Home.route)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            elevation = ButtonDefaults.elevation(0.dp),

            ) {
            Icon(
                painter = painterResource(id = R.drawable.back_arrow_ic),
                contentDescription = null,
                tint = MainGray
            )
        }
        Text(
            modifier = Modifier.layoutId("settingText"),
            text = "Настройки",
            color = Color.Black,
            fontFamily = RalewayFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun SettingsSection(
    navController: NavHostController,
    settingContent: List<SettingItem>
) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 40.dp)
            .border(0.dp, Color.White)
    ) {
        items(settingContent.size) {
            OutlinedButton(
                onClick = {
                    navController.navigate("Settings/${settingContent[it].Id.value}")
                },
                modifier = Modifier
                    .border(0.dp, Color.Transparent)
                    .padding(bottom = 8.dp)
                    .background(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Icon(
                        modifier = Modifier.padding(start = 10.dp),
                        painter = painterResource(id = settingContent[it].Icon),
                        contentDescription = null,
                        tint = MainGray,
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 18.dp),
                        text = settingContent[it].Name,
                        color = Black,
                        fontFamily = RalewayFontFamily,
                        fontWeight = FontWeight.Light,
                        fontSize = 26.sp,
                    )
                }

            }
        }
    }
}

@Composable
fun AppVersion() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            text = "CareerGuidanceCenter v1.0",
            color = Color.Black,
            fontFamily = RalewayFontFamily,
            fontWeight = FontWeight.Thin,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}