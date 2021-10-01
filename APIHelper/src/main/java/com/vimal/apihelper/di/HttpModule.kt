package com.vimal.apihelper.di

import org.koin.dsl.module

object HttpModule {
    val httpModule = module{
        single { ApplicationModule().httpClient() }
    }
}