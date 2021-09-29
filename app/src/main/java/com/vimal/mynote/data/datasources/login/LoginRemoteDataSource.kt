package com.vimal.mynote.data.datasources.login

import com.vimal.core.datasources.BaseRemote
import com.vimal.core.ktx.Observable.applyNetworkSchedulers
import com.vimal.core.models.APIResult
import com.vimal.mynote.api.APIService
import com.vimal.mynote.models.request.LoginRequest
import com.vimal.mynote.models.response.LoginResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LoginRemoteDataSource @Inject constructor(private val apiService: APIService) :BaseRemote(), LoginViewDataSource.Remote {

    override fun login(request: LoginRequest): Single<APIResult<LoginResponse>> {
        return apiService.login(request).createResult().applyNetworkSchedulers()
    }

}