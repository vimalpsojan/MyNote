package com.vimal.mynote.common

import androidx.compose.runtime.Composable
import com.vimal.core.navigation.MainDestinations
import com.vimal.mynote.navigation.SetupNavGraph
import com.vimal.uiutils.ui.theme.MyNoteTheme

@Composable
fun App() {
    MyNoteTheme {
        SetupNavGraph(MainDestinations.SPLASH)
    }
}
