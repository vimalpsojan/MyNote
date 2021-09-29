package com.vimal.mynote.api

import com.vimal.core.models.DefaultResponse
import com.vimal.mynote.models.request.LoginRequest
import com.vimal.mynote.models.response.LoginResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.adapter.rxjava3.Result
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface APIService {

    @GET(APIUrls.GET_ALL_NUMBERS)
    fun getAllNumbers(
        @Query("intStartNo") start: Int,
        @Query("intEndNo") end: Int
    ): Single<Result<DefaultResponse<List<String>>>>

    @POST(APIUrls.GET_ALL_NUMBERS)
    fun login(@Body request: LoginRequest): Single<Result<DefaultResponse<LoginResponse>>>

}