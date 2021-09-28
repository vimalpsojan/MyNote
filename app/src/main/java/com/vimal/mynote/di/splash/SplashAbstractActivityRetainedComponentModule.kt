package com.vimal.mynote.di.splash

import com.vimal.mynote.data.datasources.splash.SplashViewDataSource
import com.vimal.mynote.data.repositories.SplashViewRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class SplashAbstractActivityRetainedComponentModule {

    @Binds
    abstract fun splashViewDataSource(impl: SplashViewDataSource): SplashViewRepository

}