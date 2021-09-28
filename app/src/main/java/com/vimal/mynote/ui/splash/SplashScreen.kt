package com.vimal.mynote.ui.splash

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.vimal.mynote.R
import com.vimal.mynote.ui.MainDestinations
import com.vimal.mynote.ui.isNavigation
import com.vimal.mynote.ui.theme.MyNoteTheme
import com.vimal.mynote.ui.utils.InsetAwareTopAppBar
import com.vimal.mynote.ui.utils.isScrolled

@Composable
fun SplashScreen(
    splashViewModel: SplashViewModel,
    navigateTo: (MainDestinations) -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    val navigation by splashViewModel.navigate.collectAsState()
    SplashScreen(navigate = navigation,navigateTo = navigateTo,scaffoldState = scaffoldState)
}

@Composable
fun SplashScreen(
    navigate: MainDestinations,
    navigateTo: (MainDestinations) -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    if(navigate.isNavigation()){
        navigateTo(navigate)
      return
    }
//    val scrollState = rememberLazyListState()
//    Scaffold(
//        scaffoldState = scaffoldState,
//        snackbarHost = { SnackbarHost(hostState = it, modifier = Modifier.systemBarsPadding()) },
//        topBar = {
//            val title = stringResource(id = R.string.app_name)
//            InsetAwareTopAppBar(
//                title = {
//                    Icon(
//                        painter = painterResource(R.drawable.ic_notes),
//                        contentDescription = title,
//                        tint = MaterialTheme.colors.onBackground,
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(bottom = 4.dp, top = 10.dp)
//                    )
//                },
//                backgroundColor = MaterialTheme.colors.surface,
//                elevation = if (!scrollState.isScrolled) 0.dp else 4.dp
//            )
//        }
//    ) { innerPadding ->
        Image(
            painter = painterResource(R.drawable.ic_notes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()

        )
//    }
}

@Preview("Splash screen")
@Preview("Splash screen (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("Splash screen (big font)", fontScale = 1.5f)
@Preview("Splash screen (large screen)", device = Devices.PIXEL_C)
@Composable
fun PreviewSplashScreen() {
    MyNoteTheme {
        SplashScreen(
            navigate =MainDestinations.NONE,
            navigateTo = {  },
            scaffoldState = rememberScaffoldState()
        )
    }
}