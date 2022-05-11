package com.example.careerguidancecenter.repository

import com.example.careerguidancecenter.R
import com.example.careerguidancecenter.model.Setting

class SettingContent{

    val langSetting = Setting(R.drawable.lang_ic, "Язык")
    val themeSetting = Setting(R.drawable.sun_ic, "Цветовая тема")

    val ListLevels = listOf(langSetting, themeSetting)
}

