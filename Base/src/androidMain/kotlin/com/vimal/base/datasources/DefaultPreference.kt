package com.vimal.base.datasources

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.vimal.base.data.repositories.PreferenceProvider
import com.vimal.base.ktx.PreferenceHelper
import com.vimal.base.ktx.PreferenceHelper.set
import com.vimal.base.ktx.PreferenceHelper.get

class DefaultPreference constructor( context: Context): PreferenceProvider {
    object Fields {
        const val SELECTED_THEME = "selected_theme_dark"
        const val AUTH_TOKEN = "auth_token"
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
    }

    private val sharedPreferences by lazy {
        PreferenceHelper.customPrefs(context, "")
    }

    override fun setTheme(theme: Int) {
        sharedPreferences[Fields.SELECTED_THEME] = theme
    }

    override fun getTheme(): Int {
        return sharedPreferences[Fields.SELECTED_THEME, AppCompatDelegate.MODE_NIGHT_UNSPECIFIED]
    }

    override fun getAuthToken(): String? {
        return sharedPreferences[Fields.AUTH_TOKEN]
    }

    override fun setAuthToken(token: String?) {
        sharedPreferences[Fields.AUTH_TOKEN] = token
    }

    override fun setLoginData(firstName: String?, lastName: String?, auth: String?) {
        sharedPreferences[Fields.AUTH_TOKEN] = auth
        sharedPreferences[Fields.FIRST_NAME] = firstName
        sharedPreferences[Fields.LAST_NAME] = lastName
    }

    override fun setValue(key: String, value: Any?) {
        sharedPreferences[key] = value
    }

    override fun getValue(key: String, defaultValue: Any): Any {
        return sharedPreferences[key, defaultValue]
    }

    override fun getValue(key: String): Any? {
        return sharedPreferences[key]
    }
}