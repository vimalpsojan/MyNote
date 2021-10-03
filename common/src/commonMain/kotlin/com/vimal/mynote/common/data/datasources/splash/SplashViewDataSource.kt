package com.vimal.mynote.common.data.datasources.splash

import com.vimal.base.data.repositories.PreferenceProvider
import com.vimal.mynote.common.data.repositories.SplashViewRepository

class SplashViewDataSource constructor(private val preference: PreferenceProvider) : SplashViewRepository {
    override fun isLoginUser(): Boolean {
        return !preference.getAuthToken().isNullOrBlank()
    }
}