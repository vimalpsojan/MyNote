package com.vimal.mynote.di

import com.vimal.base.data.repositories.PreferenceProvider
import com.vimal.base.datasources.DefaultPreference
import org.koin.dsl.module

object DesktopDI {
    val desktopModule = module {
        //as singleton instances
        single { DefaultPreference() as PreferenceProvider }
    }
}