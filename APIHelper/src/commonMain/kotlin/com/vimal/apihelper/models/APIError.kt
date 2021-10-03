package com.vimal.apihelper.models

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
class APIError {

    var errorCode: Int = 500

    @SerialName("message")
    var message: String? = null
    @SerialName("trace")
    var trace: String? = null

    companion object{

        const val DECODE_ERROR = 1005
        const val ADDRESS_NOT_FOUND = 404

        fun crateOnDecode(trace:String):APIError{
            val error =APIError()
            error.errorCode = DECODE_ERROR
            error.message = "Failed of decode Error"
            error.trace = trace
            return error
        }
        fun unresolvedAddressException(message:String,trace:String):APIError{
            val error =APIError()
            error.errorCode = ADDRESS_NOT_FOUND
            error.message = message
            error.trace = trace
            return error
        }
    }
}