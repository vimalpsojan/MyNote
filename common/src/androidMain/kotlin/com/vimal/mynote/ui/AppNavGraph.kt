package com.vimal.mynote.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vimal.base.navigation.NavigationActions
import com.vimal.core.navigation.MainDestinations
import com.vimal.mynote.ui.splash.AndroidSplashViewModel
import com.vimal.mynote.ui.splash.SplashScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: MainDestinations
) {
    val action:NavigationActions<MainDestinations> = remember(navController){ MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination.name,
        route = MainDestinations.MAIN.name
    ){
        composable(MainDestinations.SPLASH.name){
            val viewModel = getViewModel<AndroidSplashViewModel>()
            viewModel.setNavigationActions(action)
            SplashScreen(viewModel)
        }
    }
}

class MainActions(navController: NavHostController) : NavigationActions<MainDestinations> {

    override val navigateTo: (MainDestinations, Boolean, MainDestinations?) -> Unit =
        { destination: MainDestinations, singleTop: Boolean, popUpTo: MainDestinations? ->
            navController.navigate(destination.name) {
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