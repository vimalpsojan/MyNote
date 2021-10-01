package com.vimal.login.data.datasources

import com.vimal.apihelper.models.APIResult
import com.vimal.login.data.repositories.LoginRepository
import com.vimal.login.models.request.LoginRequest
import com.vimal.login.models.response.LoginResponse
import javax.inject.Inject

class LoginViewDataSource @Inject constructor(private val remote: Remote) : LoginRepository {

    companion object {
        const val LOGIN = "login"
    }

    override suspend fun login(userName: String, password: String): APIResult<LoginResponse> {
        val data = remote.login(LoginRequest(userName, password))
        if(data.isSuccess){

        }
        return data
    }

    interface Remote {
        suspend fun login(request: LoginRequest): APIResult<LoginResponse>
    }
}