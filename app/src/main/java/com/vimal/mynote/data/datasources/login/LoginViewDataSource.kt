package com.vimal.mynote.data.datasources.login

import com.vimal.core.models.APIResult
import com.vimal.mynote.data.repositories.LoginRepository
import com.vimal.mynote.data.repositories.PreferenceProvider
import com.vimal.mynote.models.request.LoginRequest
import com.vimal.mynote.models.response.LoginResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LoginViewDataSource @Inject constructor(
    private val remote: Remote,
    private val preference: PreferenceProvider
) : LoginRepository {

    override fun login(userName: String, password: String): Single<APIResult<LoginResponse>> {
        return remote.login(LoginRequest(userName, password)).doOnSuccess {
            it.data?.let { loginData ->
                preference.setLoginData(loginData)
            }
        }
    }

    interface Remote {
        fun login(request: LoginRequest): Single<APIResult<LoginResponse>>
    }
}