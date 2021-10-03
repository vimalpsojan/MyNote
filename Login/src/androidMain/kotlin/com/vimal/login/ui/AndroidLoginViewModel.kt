package com.vimal.login.ui

import com.vimal.core.viewmodel.AppAndroidViewModel

class AndroidLoginViewModel constructor(viewModel:LoginViewModel): AppAndroidViewModel<LoginViewModel>(viewModel) {

    val userName = viewModel.userName


    val password = viewModel.password

    val enableLogin = viewModel.enableLogin

    val onUserName: (String) -> Unit = viewModel.onUserName

    val onPassword: (String) -> Unit = viewModel.onPassword

    val onLogin: () -> Unit = viewModel.onLogin
}