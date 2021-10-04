package com.vimal.mynote.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import com.vimal.base.navigation.NavigationActions
import com.vimal.core.navigation.MainDestinations
import com.vimal.mynote.common.FeatureNotReadyYet
import com.vimal.mynote.di.Provider
import com.vimal.mynote.navigation.NavigationController
import com.vimal.mynote.ui.splash.SplashScreen

@Composable
fun AppNavGraph(start:MainDestinations){
    val navigation = remember(){NavigationController(MainDestinations.MAIN.name)}
    val action: NavigationActions<MainDestinations> = remember(navigation){ MainActions(navigation) }
    navigation.add(MainDestinations.SPLASH.name)

    val nav = navigation.navigation.collectAsState()
    when(MainDestinations.valueOf(nav.value)){
        MainDestinations.SPLASH->{
            val viewModel = Provider().splashViewModel
            viewModel.navigationActions = action
            SplashScreen(viewModel)
        }
        else -> {
            FeatureNotReadyYet()
        }
    }

    navigation.navigate(path = start.name,addToBackStack = false)
}

class MainActions(navController: NavigationController) : NavigationActions<MainDestinations> {

    override val navigateTo: (MainDestinations, Boolean, MainDestinations?) -> Unit =
        { destination: MainDestinations, singleTop: Boolean, popUpTo: MainDestinations? ->
            navController.navigate(path = destination.name,clearTO = popUpTo?.name)
        }

    override val upPress: () -> Unit = {
        navController.backNav()

    }
}

