package com.bye.ane.core.network.fliter

fun interface FailureInterceptor {
    fun filter(exception: Throwable?): Boolean
}