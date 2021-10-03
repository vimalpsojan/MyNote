package com.vimal.apihelper.models

data class APIResult<T>(
    val statusCode: Int,
    val isSuccess: Boolean = false,
    val data: T? = null,
    val error: APIError? = null,
    val message: String? = null
)