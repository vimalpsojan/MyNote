package com.vimal.mynote.data.repositories

interface PreferenceProvider {
    fun setTheme(theme: Int)
    fun getTheme(): Int

    fun getAuthToken(): String?
    fun setAuthToken(token: String?)
}