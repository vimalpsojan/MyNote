package com.vimal.mynote.di
//
//import com.vimal.login.data.datasources.LoginRemoteDataSource
//import com.vimal.login.data.datasources.LoginViewDataSource
//import com.vimal.login.data.repositories.LoginRepository
//import com.vimal.mynote.data.datasources.splash.SplashViewDataSource
//import com.vimal.mynote.data.repositories.SplashViewRepository
//import dagger.Binds
//import dagger.Module
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ActivityRetainedComponent
//
//@Module
//@InstallIn(ActivityRetainedComponent::class)
//abstract class AbstractActivityRetainedComponentModule {
//
//    @Binds
//    abstract fun splashViewDataSource(impl: SplashViewDataSource): SplashViewRepository
//
//    @Binds
//    abstract fun loginViewDataSource(impl: LoginViewDataSource): LoginRepository
//
//    @Binds
//    abstract fun loginRemoteDataSource(impl: LoginRemoteDataSource): LoginViewDataSource.Remote
//
//}