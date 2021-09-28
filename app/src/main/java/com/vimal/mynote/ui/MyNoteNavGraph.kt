package com.vimal.mynote.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vimal.mynote.ui.splash.SplashScreen
import com.vimal.mynote.ui.splash.SplashViewModel
import androidx.hilt.navigation.compose.hiltViewModel


object MainDestinations {
    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val HOME = "home"
    const val NOTE = "note"
}

@Composable
fun MyNoteNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.SPLASH
) {
    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.SPLASH) {
            val splashViewModel =hiltViewModel<SplashViewModel>()
            SplashScreen(splashViewModel = splashViewModel,navigateTo = actions.navigateTo)
        }
    }
}

class MainActions(navController: NavHostController) {

    val navigateTo: (String) -> Unit = { navigation: String ->
        navController.navigate(navigation)
    }

    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}