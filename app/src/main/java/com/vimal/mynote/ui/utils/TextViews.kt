package com.vimal.mynote.ui.utils

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NormalTextView(value:String,modifier: Modifier = Modifier){
    Text(text = value,modifier)
}