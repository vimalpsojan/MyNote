package com.vimal.apihelper.models

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
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
}