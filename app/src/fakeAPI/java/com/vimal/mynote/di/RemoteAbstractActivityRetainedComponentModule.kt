package com.vimal.mynote.di

import com.vimal.mynote.data.datasources.login.LoginViewDataSource
import com.vimal.mynote.data.datasources.login.fake.LoginFakeRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RemoteAbstractActivityRetainedComponentModule {

    @Binds
    abstract fun loginRemoteDataSource(impl: LoginFakeRemoteDataSource): LoginViewDataSource.Remote
}