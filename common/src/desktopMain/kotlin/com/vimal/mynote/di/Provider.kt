package com.vimal.mynote.di

import com.vimal.mynote.common.splash.SplashViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Provider : KoinComponent {
    val splashViewModel by inject<SplashViewModel>()
}