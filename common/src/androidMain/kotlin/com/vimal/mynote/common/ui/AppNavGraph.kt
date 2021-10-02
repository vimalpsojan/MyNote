package com.vimal.mynote.common.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vimal.mynote.common.navigation.MainDestinations

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.SPLASH.name
) {

}