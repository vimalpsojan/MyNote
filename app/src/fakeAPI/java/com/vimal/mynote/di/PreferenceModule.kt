package com.vimal.mynote.di

import com.vimal.mynote.data.datasources.DefaultPreference
import com.vimal.mynote.data.repositories.PreferenceProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferenceModule {

    @Singleton
    @Binds
    abstract fun provideDefaultPreference(impl: DefaultPreference): PreferenceProvider
}