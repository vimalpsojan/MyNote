package com.vimal.mynote.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.vimal.mynote.NoteApp
import com.vimal.mynote.ui.theme.MyNoteTheme
import com.vimal.mynote.ui.utils.NormalTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DefaultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyNoteTheme {
                NoteApp()
            }
        }
    }
}