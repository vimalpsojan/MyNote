package com.vimal.mynote.data.datasources.splash

import com.vimal.andoidbase.data.repositories.PreferenceProvider
import com.vimal.mynote.data.repositories.SplashViewRepository

class SplashViewDataSource constructor(private val preference: PreferenceProvider) : SplashViewRepository {

    override fun isLoginUser(): Boolean {
        return !preference.getAuthToken().isNullOrBlank()
    }
}