package com.vimal.login.models.request

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
class LoginRequest(
    @SerialName("user_name")
    val userName: String,
    @SerialName("password")
    val password: String
)