package com.vimal.core.viewmodel

import com.vimal.base.viewmodel.BaseAndroidViewModel
import com.vimal.core.navigation.MainDestinations

abstract class AppAndroidViewModel<T:BaseViewModel>(viewModel: T):BaseAndroidViewModel<MainDestinations,T>(viewModel = viewModel){
}