package com.vimal.login.models.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class LoginRequest(
    @SerialName("user_name")
    val userName: String,
    @SerialName("password")
    val password: String
)