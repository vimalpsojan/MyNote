package com.vimal.mynote.ui.utils

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NormalTextView(value: String, modifier: Modifier = Modifier) {
    Text(text = value, modifier)
}

@Composable
fun OutLIneInput(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean = false,
    modifier: Modifier = Modifier,
    hint: String? = null,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = singleLine,
        modifier = modifier,
        label = {
            NormalTextView(value = label)
        },
        placeholder = {
            hint?.let {
                NormalTextView(value = it)
            }

        }
    )
}

@Composable
fun OutLInePasswordInput(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    showPassword: Boolean = false,
    mask: Char = '\u2022',
    modifier: Modifier = Modifier,
    hint: String? = null,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = {
            NormalTextView(value = label)
        },
        placeholder = {
            hint?.let {
                NormalTextView(value = it)
            }

        },
        singleLine = true,
        visualTransformation =
        if (showPassword)
            VisualTransformation.None
        else
            PasswordVisualTransformation(mask)
    )
}

@Preview("NormalTextView")
@Composable
fun NormalTextView() {
    NormalTextView("Hello")
}

@Preview("OutLIneInput")
@Composable
fun OutLIneInput() {
    OutLIneInput(label = "Label", value = "", onValueChange = {}, hint = "Hint")
}
