package com.bye.ane.core.network.fliter

import com.bye.ane.core.network.result.ResponseWrapper


fun interface BusinessErrorInterceptor<T> {
    fun filter(response: ResponseWrapper<T>?): Boolean
}