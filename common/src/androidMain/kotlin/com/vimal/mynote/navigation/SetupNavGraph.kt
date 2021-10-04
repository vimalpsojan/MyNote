package com.vimal.mynote.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.vimal.core.navigation.MainDestinations
import com.vimal.mynote.ui.AppNavGraph

@Composable
actual fun SetupNavGraph(startupPage: MainDestinations) {
    val navController = rememberNavController()
    AppNavGraph(navController = navController, startDestination = startupPage)
}