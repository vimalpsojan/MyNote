package com.vimal.mynote.common.di

import com.vimal.home.ui.HomeViewModel
import com.vimal.login.data.datasources.LoginRemoteDataSource
import com.vimal.login.data.datasources.LoginViewDataSource
import com.vimal.login.data.repositories.LoginRepository
import com.vimal.login.ui.LoginViewModel
import com.vimal.mynote.common.data.datasources.splash.SplashViewDataSource
import com.vimal.mynote.common.data.repositories.SplashViewRepository
import com.vimal.mynote.common.splash.SplashViewModel
import org.koin.dsl.module

object CommonDI {
    val commonModule  = module {
        factory { SplashViewDataSource(get()) as SplashViewRepository }
        factory { LoginViewDataSource(get(),get()) as LoginRepository }
        factory { LoginRemoteDataSource(get()) as LoginViewDataSource.Remote }

        factory { SplashViewModel(get()) }
        factory { LoginViewModel(get()) }
        factory { HomeViewModel() }

    }
}