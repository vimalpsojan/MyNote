package com.vimal.mynote.navigation

import androidx.compose.runtime.Composable
import com.vimal.core.navigation.MainDestinations
import com.vimal.mynote.common.FeatureNotReadyYet
import com.vimal.mynote.ui.AppNavGraph

@Composable
actual fun SetupNavGraph(startupPage: MainDestinations) {
    AppNavGraph(MainDestinations.SPLASH)
}