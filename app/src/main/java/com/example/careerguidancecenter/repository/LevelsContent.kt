package com.example.careerguidancecenter.repository

import com.example.careerguidancecenter.R
import com.example.careerguidancecenter.model.Level
import com.example.careerguidancecenter.ui.theme.*

class LevelContent {

    val Level1 = Level("Уровень 1", "Мысли", MainOrange, BorderOrange, R.drawable.thoughts)
    val Level2 = Level("Уровень 2", "Дела", MainBlue, BorderBlue, R.drawable.deals)
    val Level3 = Level("Уровень 3", "Вопросы", MainGreen, BorderGreen, R.drawable.answers)

    val ListLevels = listOf(Level1, Level2, Level3)
}

