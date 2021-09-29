package com.vimal.mynote.data.repositories

import com.vimal.mynote.models.response.LoginResponse

interface PreferenceProvider {
    fun setTheme(theme: Int)
    fun getTheme(): Int

    fun getAuthToken(): String?
    fun setAuthToken(token: String?)
    fun setLoginData(loginResponse: LoginResponse)
}