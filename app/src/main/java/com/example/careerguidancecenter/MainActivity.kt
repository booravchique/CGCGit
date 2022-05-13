package com.example.careerguidancecenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.careerguidancecenter.layout.LevelTwoMainScreenLayout
import com.example.careerguidancecenter.layout.SettingsScreenLayout
import com.example.careerguidancecenter.ui.theme.CareerGuidanceCenterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CareerGuidanceCenterTheme {
                LevelTwoMainScreenLayout()
            }
        }
    }
}

