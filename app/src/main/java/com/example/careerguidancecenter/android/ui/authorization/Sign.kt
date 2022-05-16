package com.example.careerguidancecenter.android.ui.authorization

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.careerguidancecenter.android.Token
import com.example.careerguidancecenter.android.presentation.QuestionsViewModel
import com.example.careerguidancecenter.android.presentation.SignInViewModel
import com.example.careerguidancecenter.android.presentation.SignUpViewModel
import com.example.careerguidancecenter.android.ui.Nav
import com.example.careerguidancecenter.android.ui.core.*
import com.example.careerguidancecenter.android.ui.core.model.HintData
import com.example.careerguidancecenter.android.ui.main.Data
import com.example.careerguidancecenter.android.ui.main.LevelsHeader
import com.example.careerguidancecenter.android.ui.main.LevelsSection
import com.example.careerguidancecenter.android.ui.setting.SettingsList
import com.example.careerguidancecenter.android.ui.setting.model.SettingType
import com.example.careerguidancecenter.android.ui.theme.BackgroundFillGray
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

@Preview
@Composable
fun Sign (){
    val navController = rememberNavController()
    val signUpViewModel = hiltViewModel<SignUpViewModel>()
    val signInViewModel = hiltViewModel<SignInViewModel>()
    val questionsViewModel = hiltViewModel<QuestionsViewModel>()
    println("dvddv")
    var startRoute = Nav.SignUp.route
    NavHost(navController = navController, startDestination = startRoute) {
        composable(Nav.SignUp.route){
            SignUp(navController, signInViewModel)
        }
        composable(Nav.SignIn.route){
            SignIn(navController, signUpViewModel)
        }

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


            if(level.HintData !=null) {
                LaunchedEffect(key1 = true) {
                    delay(1000L)
                    navController.navigate("${Nav.Levels.route}/${levelId}")
                }
            } else {
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
            LevelOneMainScreenLayout(navController, questionsViewModel)
        }

        composable(Nav.ChoiceLink.route) {
            LevelTwoMainScreenLayout(navController)
        }

        composable(Nav.ProfessionsLink.route) {
            LevelThreeMainScreenLayout(navController)
        }


    }



}