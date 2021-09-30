package com.vimal.mynote.data.datasources.login.fake

import com.google.gson.reflect.TypeToken
import com.vimal.core.datasources.FakeBaseRemote
import com.vimal.core.models.APIResult
import com.vimal.core.models.DefaultResponse
import com.vimal.mynote.data.datasources.login.LoginViewDataSource
import com.vimal.mynote.models.request.LoginRequest
import com.vimal.mynote.models.response.LoginResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LoginFakeRemoteDataSource @Inject constructor(): FakeBaseRemote(), LoginViewDataSource.Remote {

    private val fakeResponse = "{\n" +
            "    \"status\" : \"Succeess\",\n" +
            "    \"code\" : 200,\n" +
            "    \"message\" : \"Login Succeess\",\n" +
            "    \"data\":{\n" +
            "        \"first_name\" : \"Vimal\",\n" +
            "        \"last_name\" : \"Sojan\",\n" +
            "        \"auth\" : \"gajnxaskcnskcmsc\"\n" +
            "    }\n" +
            "}"

    override fun login(request: LoginRequest): Single<APIResult<LoginResponse>> {
        return getResponse(fakeResponse,object : TypeToken<DefaultResponse<LoginResponse>>() {}.type)
    }
}