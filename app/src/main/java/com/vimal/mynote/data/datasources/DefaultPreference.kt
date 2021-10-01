package com.vimal.mynote.data.datasources

import android.content.Context
import com.vimal.core.ktx.PreferenceHelper
import com.vimal.core.ktx.PreferenceHelper.get
import com.vimal.core.ktx.PreferenceHelper.set
import com.vimal.mynote.data.repositories.PreferenceProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DefaultPreference @Inject constructor(@ApplicationContext context: Context):
    PreferenceProvider {

    object Fields {
        const val SELECTED_THEME = "selected_theme_dark"
        const val AUTH_TOKEN = "auth_token"
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
    }

    private val sharedPreferences by lazy {
        PreferenceHelper.customPrefs(context, "")
    }

//    override fun setTheme(theme: Int) {
//        sharedPreferences[Fields.SELECTED_THEME] = theme
//    }
//
//    override fun getTheme(): Int {
//        return sharedPreferences[Fields.SELECTED_THEME, AppCompatDelegate.MODE_NIGHT_UNSPECIFIED]
//    }

    override fun getAuthToken(): String? {
        return sharedPreferences[Fields.AUTH_TOKEN]
    }

    override fun setAuthToken(token: String?) {
        sharedPreferences[Fields.AUTH_TOKEN] = token
    }

}