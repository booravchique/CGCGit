package com.example.careerguidancecenter.android.ui.setting.model

data class SettingItem(

    val Id: SettingType,
    val Icon: Int,
    val Name: String,
)

enum class SettingType(val value: Int){
    Language(0),
    Theme(1);

    companion object {
        fun fromInt(value: Int) = SettingType.values().first { it.value == value }
    }
}