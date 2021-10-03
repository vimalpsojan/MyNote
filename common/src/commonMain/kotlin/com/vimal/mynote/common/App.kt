package com.vimal.mynote.common

import androidx.compose.runtime.Composable
import com.vimal.uiutils.ui.theme.MyNoteTheme

@Composable
fun App() {
    MyNoteTheme {
        FeatureNotReadyYet()
        SetupNavGraph()
    }
}
