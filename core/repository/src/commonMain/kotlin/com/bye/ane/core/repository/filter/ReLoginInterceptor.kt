package com.bye.ane.core.repository.filter

import com.bye.ane.core.network.fliter.BusinessErrorInterceptor
import com.bye.ane.core.network.result.ResponseWrapper

class ReLoginInterceptor<T> : BusinessErrorInterceptor<T> {
    override fun filter(response: ResponseWrapper<T>?): Boolean {
        return false
    }

}