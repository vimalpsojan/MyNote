package com.vimal.login.di

import com.vimal.login.data.datasources.LoginViewDataSource
import com.vimal.login.data.repositories.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class AbstractActivityRetainedComponentModule {
    @Binds
    abstract fun loginViewDataSource(impl: LoginViewDataSource): LoginRepository
}