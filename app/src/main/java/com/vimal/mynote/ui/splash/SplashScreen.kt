package com.vimal.mynote.ui.splash

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.vimal.mynote.R
import com.vimal.uiutils.ui.theme.MyNoteTheme

@Composable
fun SplashScreen(
    splashViewModel: SplashViewModel
) {
    SplashScreen()
}

@Composable
fun SplashScreen(

) {
    Image(
        painter = painterResource(R.drawable.ic_notes),
        contentDescription = null,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    )
}

@Preview("Splash screen")
@Preview("Splash screen (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("Splash screen (big font)", fontScale = 1.5f)
@Preview("Splash screen (large screen)", device = Devices.PIXEL_C)
@Composable
fun PreviewSplashScreen() {
    MyNoteTheme {
        SplashScreen()
    }
}