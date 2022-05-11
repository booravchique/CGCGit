package com.example.careerguidancecenter.layout

import android.graphics.Paint
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CheckboxDefaults.colors
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.careerguidancecenter.R
import com.example.careerguidancecenter.model.Setting
import com.example.careerguidancecenter.repository.SettingContent
import com.example.careerguidancecenter.ui.theme.MainGray
import com.example.careerguidancecenter.ui.theme.RalewayFontFamily

@Preview
@Composable
fun SettingsScreenLayout() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            SettingsHeader()
            SettingsSection(settingContent = SettingContent().ListLevels)
        }
        AppVersion()
    }
}

@Composable
fun SettingsHeader() {
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
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 10.dp)
//                .layoutId("parentRow"),
//            verticalAlignment = Alignment.CenterVertically
//        ) {

        Button(
            modifier = Modifier.layoutId("backButton"),
            onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            elevation = ButtonDefaults.elevation(0.dp),

            ) {
            Icon(
                painter = painterResource(id = R.drawable.back_arrow_ic),
                contentDescription = null,
            )
        }
        Text(
            modifier = Modifier.layoutId("settingText"),
            text = "Настройки",
            color = Black,
            fontFamily = RalewayFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
        )

//        }
    }
}

@Composable
fun SettingsSection(
    settingContent: List<Setting>
) {
    LazyColumn(
        modifier = Modifier.padding(top = 40.dp)
    ) {
        items(settingContent.size) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 8.dp),
            ) {
                Icon(
                    modifier = Modifier.padding(start = 10.dp),
                    painter = painterResource(id = settingContent[it].Icon),
                    contentDescription = null,
                    tint = MainGray
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

@Composable
fun AppVersion() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
            text = "CareerGuidanceCenter v1.0",
            color = Black,
            fontFamily = RalewayFontFamily,
            fontWeight = FontWeight.Thin,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}