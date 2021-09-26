package com.vimal.mynote.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.vimal.mynote.ui.ui.theme.TemplateProjectTheme
import com.vimal.mynote.ui.utils.NormalTextView

class DefaultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemplateProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }


    @Composable
    fun Greeting(name: String) {
        NormalTextView(value = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        TemplateProjectTheme {
            Greeting("Android")
        }
    }
}