package com.vimal.login.data.datasources

import com.vimal.apihelper.datasources.BaseRemote
import com.vimal.apihelper.models.APIResult
import com.vimal.apihelper.models.DefaultResponse
import com.vimal.login.models.request.LoginRequest
import com.vimal.login.models.response.LoginResponse
import io.ktor.client.*
import io.ktor.client.request.*

class LoginRemoteDataSource constructor(private val client: HttpClient) : BaseRemote(),
    LoginViewDataSource.Remote {
    override suspend fun login(request: LoginRequest): APIResult<LoginResponse> {
        return try {
            client.post<DefaultResponse<LoginResponse>>(LoginViewDataSource.LOGIN) {
                body = request
            }.createResult()
        } catch (t: Throwable) {
            t.createResult()
        }
    }
}