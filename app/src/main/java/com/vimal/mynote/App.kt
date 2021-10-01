package com.vimal.mynote

import android.app.Application
import com.vimal.apihelper.di.HttpModule.httpModule
import com.vimal.mynote.di.AndroidDI.androidModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(androidModule, httpModule)
        }
    }
}