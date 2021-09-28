package com.vimal.mynote

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.vimal.mynote.ui.MyNoteNavGraph
import com.vimal.mynote.ui.theme.MyNoteTheme

@Composable
fun NoteApp() {
    MyNoteTheme {
        ProvideWindowInsets {
            val systemUiController = rememberSystemUiController()
            val darkIcons = MaterialTheme.colors.isLight
            SideEffect {
                systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = darkIcons)
            }
            val navController = rememberNavController()
            MyNoteNavGraph(
                navController = navController
            )
        }
    }
}