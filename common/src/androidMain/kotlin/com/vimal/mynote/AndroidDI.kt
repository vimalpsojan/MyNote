package com.vimal.mynote


import com.vimal.base.data.repositories.PreferenceProvider
import com.vimal.base.datasources.DefaultPreference
import com.vimal.mynote.ui.splash.AndroidSplashViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

object AndroidDI {
    val androidModule  = module {
        //as singleton instances
        single { DefaultPreference(get()) as PreferenceProvider }

        viewModel { AndroidSplashViewModel(get()) }
    }
}