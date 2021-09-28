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


enum class MainDestinations {
    SPLASH, LOGIN, REGISTER, HOME, NOTE, NONE
}

fun MainDestinations.isNavigation(): Boolean {
    return this != MainDestinations.NONE
}

@Composable
fun MyNoteNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.SPLASH.name
) {
    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.SPLASH.name) {
            val splashViewModel = hiltViewModel<SplashViewModel>()
            SplashScreen(splashViewModel = splashViewModel, navigateTo = actions.navigateTo)
        }
    }
}

class MainActions(navController: NavHostController) {

    val navigateTo: (MainDestinations) -> Unit = { navigation: MainDestinations ->
        navController.navigate(navigation.name)
    }

    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}