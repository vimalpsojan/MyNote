package com.vimal.mynote

import android.app.Application
import com.vimal.apihelper.di.HttpModule.httpModule
import com.vimal.mynote.AndroidDI.androidModule
import com.vimal.mynote.common.di.CommonDI.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(commonModule,androidModule, httpModule)
        }
    }
}