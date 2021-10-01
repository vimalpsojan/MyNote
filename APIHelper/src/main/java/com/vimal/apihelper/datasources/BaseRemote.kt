package com.vimal.apihelper.datasources

import com.vimal.apihelper.models.APIError
import com.vimal.apihelper.models.APIResult
import com.vimal.apihelper.models.DefaultResponse
import io.ktor.client.features.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json


abstract class BaseRemote {

    private fun <T> getError(response: DefaultResponse<T>): APIError {
        val error = APIError()
        error.errorCode = response.getCode()
        error.message = response.message
        error.trace = response.reason
        return error
    }

    suspend fun <T> Throwable.createResult(): APIResult<T> {
        return when (this) {
            is ClientRequestException -> {
                getError()
            }
            else -> {
                throw this
            }
        }
    }

    private suspend fun <T> ClientRequestException.getError(): APIResult<T> {
        val res = response.readText(Charsets.UTF_8)
        var isError = false
        val error = try {
            Json.decodeFromString(APIError.serializer(), res)
        } catch (ex: Exception) {
            isError = true
            APIError.crateOnDecode(res)
        }
        return APIResult(
            statusCode = if (isError) error.errorCode else this.response.status.value,
            isSuccess = false,
            null,
            error,
            message
        )
    }

    @Throws(Throwable::class)
    fun <T> DefaultResponse<T>.createResult(): APIResult<T> {
        return if (isSuccess() && data != null) {
            APIResult(statusCode = getCode(), isSuccess = isSuccess(), this.data, null, message)
        } else {
            APIResult(
                statusCode = getCode(),
                isSuccess = isSuccess(),
                this.data,
                getError(this),
                message
            )
        }
    }
}