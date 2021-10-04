package com.vimal.login.data.repositories

import com.vimal.apihelper.models.APIResult
import com.vimal.login.models.response.LoginResponse

interface LoginRepository {
    suspend fun login(userName: String, password: String): APIResult<LoginResponse>
}