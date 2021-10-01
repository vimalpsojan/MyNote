package com.vimal.mynote.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vimal.andoidbase.navigation.NavigationActions
import com.vimal.core.vnavigation.MainDestinations
import com.vimal.home.ui.HomeScreen
import com.vimal.home.ui.HomeViewModel
import com.vimal.login.ui.LoginScreen
import com.vimal.login.ui.LoginViewModel
import com.vimal.mynote.ui.splash.SplashScreen
import com.vimal.mynote.ui.splash.SplashViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.SPLASH.name
) {
    val actions: NavigationActions<MainDestinations> =
        remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination,
        route = MainDestinations.MAIN.name
    ) {
        composable(MainDestinations.SPLASH.name) {
            val viewModel = getViewModel<SplashViewModel>()
            viewModel.navigationActions = actions
            SplashScreen(splashViewModel = viewModel)
        }
        composable(MainDestinations.LOGIN.name) {
            val viewModel = getViewModel<LoginViewModel>()
            viewModel.navigationActions = actions
            LoginScreen(viewModel = viewModel)
        }
        composable(MainDestinations.HOME.name) {
            val viewModel = getViewModel<HomeViewModel>()
            viewModel.navigationActions = actions
            HomeScreen(viewModel = viewModel)
        }
    }
}

class MainActions(navController: NavHostController) : NavigationActions<MainDestinations> {

    override val navigateTo: (MainDestinations, Boolean, MainDestinations?) -> Unit =
        { navigation: MainDestinations, singleTop: Boolean, popUpTo: MainDestinations? ->
            navController.navigate(navigation.name) {
                launchSingleTop = singleTop
                popUpTo?.let {
                    popUpTo(it.name)
                }
            }
        }

    override val upPress: () -> Unit = {
        navController.navigateUp()
    }
}