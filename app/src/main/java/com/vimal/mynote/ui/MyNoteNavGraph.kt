package com.vimal.mynote.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vimal.core.ui.NavigationActions
import com.vimal.mynote.ui.home.HomeScreen
import com.vimal.mynote.ui.home.HomeViewModel
import com.vimal.mynote.ui.login.LoginScreen
import com.vimal.mynote.ui.login.LoginViewModel
import com.vimal.mynote.ui.splash.SplashScreen
import com.vimal.mynote.ui.splash.SplashViewModel


enum class MainDestinations {
    MAIN, SPLASH, LOGIN, HOME
}

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
            val splashViewModel = hiltViewModel<SplashViewModel>()
            splashViewModel.navigationActions = actions
            SplashScreen(splashViewModel = splashViewModel)
        }
        composable(MainDestinations.LOGIN.name) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            loginViewModel.navigationActions = actions
            LoginScreen(loginViewModel = loginViewModel)
        }
        composable(MainDestinations.HOME.name){
            val homeViewModel = hiltViewModel<HomeViewModel>()
            homeViewModel.navigationActions = actions
            HomeScreen(viewModel = homeViewModel)
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