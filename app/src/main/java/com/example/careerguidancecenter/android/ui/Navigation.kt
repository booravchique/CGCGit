package com.example.careerguidancecenter.android.ui

import com.example.careerguidancecenter.android.ui.setting.model.SettingType

sealed class Nav(val route: String) {
    object Home : Nav("Home")
    object SignIn : Nav("SignIn")
    object SignUp : Nav("SignUp")
    object Start : Nav("Start")

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

    object QuestionLink : Nav("QuestionLink")

    object ChoiceLink : Nav("ChoiceLink")

    object ProfessionsLink : Nav("ProfessionsLink")

}