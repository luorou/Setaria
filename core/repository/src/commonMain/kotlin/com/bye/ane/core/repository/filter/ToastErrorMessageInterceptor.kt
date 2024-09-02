package com.bye.ane.core.repository.filter

import com.bye.ane.core.network.fliter.BusinessErrorInterceptor
import com.bye.ane.core.network.result.ResponseWrapper

class ToastErrorMessageInterceptor<T> : BusinessErrorInterceptor<T> {
    override fun filter(response: ResponseWrapper<T>?): Boolean {
        if (response?.code == 200) {
            return false
        }
        val message = response?.message

        return true
    }

}