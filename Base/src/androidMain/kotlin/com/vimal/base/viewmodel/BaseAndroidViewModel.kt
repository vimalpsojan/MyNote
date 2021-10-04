package com.vimal.base.viewmodel

import androidx.lifecycle.ViewModel
import com.vimal.base.navigation.NavigationActions

abstract class BaseAndroidViewModel<Navigation, T : ComposeBaseViewModel<Navigation>>(private val viewModel: T) : ViewModel() {
    fun setNavigationActions(navigationActions: NavigationActions<Navigation>) {
        viewModel.navigationActions = navigationActions
    }

    val loading = viewModel.loading
    val infoMessage = viewModel.infoMessage
}