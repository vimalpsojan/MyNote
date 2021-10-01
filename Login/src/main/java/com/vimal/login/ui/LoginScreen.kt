package com.vimal.login.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.google.accompanist.insets.systemBarsPadding
import com.vimal.andoidbase.models.Event
import com.vimal.andoidbase.models.LoadingMessageData
import com.vimal.login.R
import com.vimal.uiutils.ui.theme.MyNoteTheme
import com.vimal.uiutils.ui.utils.InsetAwareTopAppBar
import com.vimal.uiutils.ui.utils.OutLIneInput
import com.vimal.uiutils.ui.utils.OutLInePasswordInput
import com.vimal.uiutils.ui.utils.isScrolled

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    val userName by viewModel.userName.collectAsState()
    val password by viewModel.password.collectAsState()
    val enableLogin by viewModel.enableLogin.collectAsState()
    val loadingMessageData by viewModel.loading.collectAsState()
    LoginScreen(
        userName = userName,
        onUserNmeChange = viewModel.onUserName,
        password = password,
        onPasswordChange = viewModel.onPassword,
        enableLogin = enableLogin,
        onLogin = viewModel.onLogin,
        loadingMessageData = loadingMessageData,
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
    loadingMessageData: Event<LoadingMessageData>? = null,
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
            loadingMessageData = loadingMessageData,
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
    loadingMessageData: Event<LoadingMessageData>? = null,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 0.dp, bottom = 0.dp)
    ) {
        val (usernameTxt, passwordTxt, loginBtn) = createRefs()
        val localFocusManager = LocalFocusManager.current
        OutLIneInput(
            label = stringResource(id = R.string.user_name),
            value = userName ?: "",
            onValueChange = onUserNmeChange,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
                autoCorrect = false
            ),
            keyboardActions = KeyboardActions(onNext = {
                localFocusManager.moveFocus(FocusDirection.Down)
            }),
            modifier = Modifier.constrainAs(usernameTxt) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
        )
        OutLInePasswordInput(
            label = stringResource(id = R.string.password),
            value = password ?: "",
            onValueChange = onPasswordChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = if (enableLogin) ImeAction.Done else ImeAction.Next,
                autoCorrect = false
            ),
            keyboardActions = KeyboardActions(
                onNext = { localFocusManager.clearFocus() },
                onDone = {
                    localFocusManager.clearFocus()
                    onLogin()
                }),
            modifier = Modifier.constrainAs(passwordTxt) {
                top.linkTo(usernameTxt.bottom, 10.dp)
                start.linkTo(usernameTxt.start)
                end.linkTo(usernameTxt.end)
                width = Dimension.fillToConstraints
            }
        )
        if (loadingMessageData?.get()?.isLoading == true) {
            CircularProgressIndicator(modifier = Modifier.constrainAs(loginBtn) {
                start.linkTo(passwordTxt.start)
                end.linkTo(passwordTxt.end)
                top.linkTo(passwordTxt.bottom)
                bottom.linkTo(parent.bottom)
            })
        } else {
            Button(
                onClick = onLogin,
                enabled = enableLogin,
                modifier = Modifier.constrainAs(loginBtn) {
                    start.linkTo(passwordTxt.start)
                    end.linkTo(passwordTxt.end)
                    linkTo(
                        top = passwordTxt.bottom,
                        bottom = parent.bottom,
                        bottomMargin = 20.dp,
                        bias = 1F
                    )
                    width = Dimension.fillToConstraints

                }) {
                Text(text = stringResource(id = R.string.login))
            }
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