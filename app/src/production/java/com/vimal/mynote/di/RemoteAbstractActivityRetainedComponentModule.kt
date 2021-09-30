package com.vimal.mynote.di

import com.vimal.mynote.data.datasources.login.LoginRemoteDataSource
import com.vimal.mynote.data.datasources.login.LoginViewDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RemoteAbstractActivityRetainedComponentModule {
    @Binds
    abstract fun loginRemoteDataSource(impl: LoginRemoteDataSource): LoginViewDataSource.Remote
}