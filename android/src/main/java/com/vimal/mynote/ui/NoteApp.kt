package com.vimal.mynote.ui

import androidx.compose.runtime.Composable
import com.vimal.mynote.common.App
import com.vimal.uiutils.ui.theme.MyNoteTheme

@Composable
fun NoteApp(){
    MyNoteTheme {
        App()
    }
}