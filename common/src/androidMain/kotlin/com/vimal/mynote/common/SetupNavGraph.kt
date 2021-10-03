package com.vimal.mynote.common

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
actual fun SetupNavGraph() {
    val navController = rememberNavController()
}