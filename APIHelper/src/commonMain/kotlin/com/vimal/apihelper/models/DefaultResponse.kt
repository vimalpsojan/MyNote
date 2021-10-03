package com.vimal.apihelper.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class DefaultResponse<T> {
    @SerialName(value = "status")
    var status: String? = null

    @SerialName("code")
    var code: Int? = null

    @SerialName("message")
    var message: String? = null

    @SerialName("data")
    var data: T? = null

    @SerialName("reason")
    var reason: String? = null


    fun getCode(): Int {
      return code?:500
    }

    fun isSuccess(): Boolean {
        return getCode() in (200 until 300)
    }
}