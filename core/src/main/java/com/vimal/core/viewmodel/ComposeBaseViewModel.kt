package com.vimal.core.viewmodel

import androidx.lifecycle.ViewModel
import com.vimal.core.ui.NavigationActions

abstract class ComposeBaseViewModel<Navigation> : ViewModel() {

    lateinit var navigationActions: NavigationActions<Navigation>

    fun navigate(navigation:Navigation){
        navigationActions.navigateTo(navigation)
    }

    fun onBackPress(){
        navigationActions.upPress()
    }
}