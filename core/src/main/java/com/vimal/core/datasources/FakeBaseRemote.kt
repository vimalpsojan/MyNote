package com.vimal.core.datasources

import com.google.gson.Gson
import com.vimal.core.models.APIResult
import com.vimal.core.models.DefaultResponse
import io.reactivex.rxjava3.core.Single
import java.lang.reflect.Type

abstract class FakeBaseRemote {

    fun <T> getResponse(response: String,typeOfT:Type): Single<APIResult<T>> {
        return Single.just(getAPIResult(response,typeOfT))
    }

    private fun <T> getResult(response: String,typeOfT:Type): DefaultResponse<T> {
        return Gson().fromJson(response, typeOfT)
    }

    private fun <T> getAPIResult(response: String,typeOfT:Type): APIResult<T> {
        return APIResult(statusCode = 200, isSuccess = true, data = getResult<T>(response,typeOfT).data)
    }

}