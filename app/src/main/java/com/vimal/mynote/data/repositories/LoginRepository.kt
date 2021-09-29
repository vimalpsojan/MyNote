package com.vimal.mynote.data.repositories

import com.vimal.core.models.APIResult
import com.vimal.mynote.models.response.LoginResponse
import io.reactivex.rxjava3.core.Single

interface LoginRepository {
    fun login(userName:String,password:String): Single<APIResult<LoginResponse>>
}