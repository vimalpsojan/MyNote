package com.vimal.mynote.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.vimal.uiutils.ui.theme.MyNoteTheme

@Composable
fun NoteApp() {
    MyNoteTheme {
        ProvideWindowInsets {
            val navController = rememberNavController()
            AppNavGraph(
                navController = navController
            )
        }
    }
}