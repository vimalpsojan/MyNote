package com.vimal.mynote.ui.login

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.vimal.mynote.R
import com.vimal.mynote.ui.theme.MyNoteTheme
import com.vimal.mynote.ui.utils.*

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {

    val userName by loginViewModel.userName.observeAsState()
    val password by loginViewModel.password.observeAsState()
    val enableLogin by loginViewModel.enableLogin.observeAsState()
    LoginScreen(
        userName = userName,
        onUserNmeChange = loginViewModel.onUserName,
        password = password,
        onPasswordChange = loginViewModel.onPassword,
        enableLogin = enableLogin ?: false,
        onLogin = loginViewModel.onLogin,
        scaffoldState = scaffoldState
    )
}

@Composable
fun LoginScreen(
    userName: String?,
    onUserNmeChange: (String) -> Unit,
    password: String?,
    onPasswordChange: (String) -> Unit,
    enableLogin: Boolean,
    onLogin: () -> Unit,
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
        CreteLoginForm(
            userName = userName,
            onUserNmeChange = onUserNmeChange,
            password = password,
            onPasswordChange = onPasswordChange,
            enableLogin = enableLogin,
            onLogin = onLogin,
            modifier = modifier
        )
    }
}

@Composable
fun CreteLoginForm(
    userName: String?,
    onUserNmeChange: (String) -> Unit,
    password: String?,
    onPasswordChange: (String) -> Unit,
    enableLogin: Boolean,
    onLogin: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val inputModifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
        OutLIneInput(
            label = stringResource(id = R.string.user_name),
            value = userName ?: "",
            onValueChange = onUserNmeChange,
            singleLine = true,
            modifier = inputModifier
        )
        OutLInePasswordInput(
            label = stringResource(id = R.string.password),
            value = password ?: "",
            onValueChange = onPasswordChange,
            modifier = inputModifier
        )
        Button(onClick = onLogin,enabled = enableLogin,modifier = inputModifier) {
            NormalTextView(value = stringResource(id = R.string.login))
        }
    }
}

@Preview("Login Screen")
@Preview("Login Screen (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("Login Screen (big font)", fontScale = 1.5f)
@Preview("Login Screen (large screen)", device = Devices.PIXEL_C)
@Composable
fun PreviewSplashScreen() {
    MyNoteTheme {
        LoginScreen(
            scaffoldState = rememberScaffoldState(),
            userName = null,
            onUserNmeChange = {},
            password = null,
            onPasswordChange = {},
            enableLogin = true,
            onLogin = {})
    }
}