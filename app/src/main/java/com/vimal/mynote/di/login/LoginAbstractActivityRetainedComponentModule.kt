package com.vimal.mynote.di.login

import com.vimal.mynote.data.datasources.login.LoginRemoteDataSource
import com.vimal.mynote.data.datasources.login.LoginViewDataSource
import com.vimal.mynote.data.repositories.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class LoginAbstractActivityRetainedComponentModule {

    @Binds
    abstract fun loginViewDataSource(impl: LoginViewDataSource): LoginRepository

    @Binds
    abstract fun loginRemoteDataSource(impl: LoginRemoteDataSource): LoginViewDataSource.Remote
}