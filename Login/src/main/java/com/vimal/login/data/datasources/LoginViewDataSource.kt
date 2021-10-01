package com.vimal.login.data.datasources

import com.vimal.apihelper.datasources.BaseRemote
import com.vimal.apihelper.models.APIResult
import com.vimal.apihelper.models.DefaultResponse
import com.vimal.login.data.repositories.LoginRepository
import com.vimal.login.models.request.LoginRequest
import com.vimal.login.models.response.LoginResponse
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class LoginViewDataSource @Inject constructor(private val client: HttpClient) : BaseRemote(),
    LoginRepository {

    override suspend fun login(userName: String, password: String): APIResult<LoginResponse> {
        return try {
            client.post<DefaultResponse<LoginResponse>>("") {
                body = LoginRequest(userName, password)
            }.createResult()
        } catch (t: Throwable) {
            t.createResult()
        }
    }
}