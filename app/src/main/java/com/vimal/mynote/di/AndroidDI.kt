package com.vimal.mynote.di

import com.vimal.andoidbase.data.datasources.DefaultPreference
import com.vimal.andoidbase.data.repositories.PreferenceProvider
import com.vimal.home.ui.HomeViewModel
import com.vimal.login.data.datasources.LoginRemoteDataSource
import com.vimal.login.data.datasources.LoginViewDataSource
import com.vimal.login.data.repositories.LoginRepository
import com.vimal.login.ui.LoginViewModel
import com.vimal.mynote.data.datasources.splash.SplashViewDataSource
import com.vimal.mynote.data.repositories.SplashViewRepository
import com.vimal.mynote.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AndroidDI {
    val androidModule  = module {

        //as singleton instances
        single { DefaultPreference(get()) as PreferenceProvider }

        // to produce a new instance each time
        factory { SplashViewDataSource(get()) as SplashViewRepository }
        factory { LoginViewDataSource(get(),get()) as LoginRepository }
        factory { LoginRemoteDataSource(get()) as LoginViewDataSource.Remote }

        viewModel { SplashViewModel(get()) }
        viewModel { LoginViewModel(get()) }
        viewModel { HomeViewModel() }
    }
}