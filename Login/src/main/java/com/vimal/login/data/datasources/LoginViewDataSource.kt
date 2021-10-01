package com.vimal.login.data.datasources

import com.vimal.andoidbase.data.repositories.PreferenceProvider
import com.vimal.apihelper.models.APIResult
import com.vimal.login.data.repositories.LoginRepository
import com.vimal.login.models.request.LoginRequest
import com.vimal.login.models.response.LoginResponse
import javax.inject.Inject

class LoginViewDataSource @Inject constructor(
    private val remote: Remote,
    private val preference: PreferenceProvider
) : LoginRepository {

    companion object {
        const val LOGIN = "login"
    }

    override suspend fun login(userName: String, password: String): APIResult<LoginResponse> {
        val response = remote.login(LoginRequest(userName, password))
        if (response.isSuccess) {
            preference.setLoginData(
                firstName = response.data?.firstName,
                lastName = response.data?.lastName,
                auth = response.data?.auth
            )
        }
        return response
    }

    interface Remote {
        suspend fun login(request: LoginRequest): APIResult<LoginResponse>
    }
}