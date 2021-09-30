package com.vimal.mynote.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.vimal.mynote.R
import com.vimal.mynote.ui.utils.InsetAwareTopAppBar
import com.vimal.mynote.ui.utils.isScrolled

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    HomeScreen(
        scaffoldState = scaffoldState
    )
}

@Composable
fun HomeScreen(
    scaffoldState: ScaffoldState
) {
    val scrollState = rememberLazyListState()
    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = { SnackbarHost(hostState = it, modifier = Modifier.systemBarsPadding()) },
        topBar = {
            val title = stringResource(id = R.string.app_name)
            InsetAwareTopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 4.dp, top = 10.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_notes),
                            contentDescription = title,
                            tint = MaterialTheme.colors.onBackground,
                            modifier = Modifier
                        )
                        Text(
                            text = title,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.surface,
                elevation = if (!scrollState.isScrolled) 0.dp else 4.dp
            )
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)

    }
}