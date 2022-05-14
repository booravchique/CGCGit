package com.example.careerguidancecenter.android.ui

import com.example.careerguidancecenter.android.ui.setting.model.SettingType

sealed class Nav(val route: String) {
    object Home : Nav("Home")

    object Levels : Nav("Levels") {

        const val routeWithArgument: String = "Levels/{levelId}"

        const val argument0: String = "levelId"
    }

    object LevelsLoad : Nav("LevelsLoad") {

        const val routeWithArgument: String = "LevelsLoad/{levelId}"

        const val argument0: String = "levelId"
    }

    object Settings : Nav("Settingss"){
        const val routeWithArgument: String = "Settings/{settingId}"

        const val argument0: String = "0"
    }
}