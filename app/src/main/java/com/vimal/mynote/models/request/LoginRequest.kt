package com.vimal.mynote.models.request

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class LoginRequest (
    @SerializedName("user_name")
    @Expose
    val userName: String,
    @SerializedName("password")
    @Expose
    val password: String
)