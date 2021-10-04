package com.vimal.base.datasources

import com.vimal.base.data.repositories.PreferenceProvider

class DefaultPreference : PreferenceProvider {
    override fun setTheme(theme: Int) {

    }

    override fun getTheme(): Int {
        TODO("Not yet implemented")
    }

    override fun getAuthToken(): String? {
        return null
    }

    override fun setAuthToken(token: String?) {

    }

    override fun setLoginData(firstName: String?, lastName: String?, auth: String?) {

    }

    override fun setValue(key: String, value: Any?) {

    }

    override fun getValue(key: String, defaultValue: Any): Any {
        TODO("Not yet implemented")
    }

    override fun getValue(key: String): Any? {
        TODO("Not yet implemented")
    }
}