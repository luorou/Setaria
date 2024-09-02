package com.bye.ane.core.repository.filter

import com.bye.ane.core.network.fliter.FailureInterceptor

class FailureInterceptorImpl : FailureInterceptor {

    override fun filter(exception: Throwable?): Boolean {
        println(exception?.message)
        return true
    }
}