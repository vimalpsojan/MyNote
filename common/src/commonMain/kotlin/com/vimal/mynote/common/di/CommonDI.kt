package com.vimal.mynote.common.di

import com.vimal.mynote.common.data.datasources.splash.SplashViewDataSource
import com.vimal.mynote.common.data.repositories.SplashViewRepository
import com.vimal.mynote.common.splash.SplashViewModel
import org.koin.dsl.module

object CommonDI {
    val commonModule  = module {
        factory { SplashViewDataSource(get()) as SplashViewRepository }
        factory { SplashViewModel(get()) }
    }
}