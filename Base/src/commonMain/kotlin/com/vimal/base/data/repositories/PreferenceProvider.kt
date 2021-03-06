package com.vimal.base.data.repositories

interface PreferenceProvider {
    fun setTheme(theme: Int)
    fun getTheme(): Int
    fun getAuthToken(): String?
    fun setAuthToken(token: String?)
    fun setLoginData(firstName:String?,lastName:String?,auth:String?)
    fun setValue(key: String, value: Any?)
    fun getValue(key: String, defaultValue: Any): Any
    fun getValue(key: String): Any?
}