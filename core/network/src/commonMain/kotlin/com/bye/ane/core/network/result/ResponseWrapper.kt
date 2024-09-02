package com.bye.ane.core.network.result

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ResponseWrapper<T> {
    @SerialName("code")  val code: Int? = null
    @SerialName("success")  val success: Boolean = false
    @SerialName("data")  val data: T? = null
    @SerialName("message")  val message: String? = null
}