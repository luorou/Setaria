package com.bye.ane.core.network.fliter

import com.bye.ane.core.network.result.ResponseWrapper

class ResponseXFilter<T>(private val builder: Builder<T>) {

    fun process(): T? {
        var intercept = false

        if (builder.exception != null&&builder.failureInterceptor!=null) {
            builder.failureInterceptor?.filter(builder.exception)
            return null
        }
        builder.interceptors.forEach {
            intercept = it.filter(builder.body)
        }
        if (intercept) {
            return null
        }
        return builder.body?.data
    }

    class Builder<T>() {
        internal var body: ResponseWrapper<T>? = null

        //
        internal var exception: Throwable? = null

        //
        internal val interceptors = ArrayList<BusinessErrorInterceptor<T>>()

        //
        internal var failureInterceptor: FailureInterceptor? = null

        fun setResponse(body: ResponseWrapper<T>?): Builder<T> {
            this.body = body
            return this
        }

        fun setException(e: Throwable): Builder<T> {
            this.exception = e
            return this
        }

        //
        fun addBusinessInterceptor(it: BusinessErrorInterceptor<T>): Builder<T> {
            interceptors.add(it)
            return this
        }

        fun setFailureInterceptor(it: FailureInterceptor): Builder<T> {
            this.failureInterceptor = it
            return this
        }

        //
        fun build(): ResponseXFilter<T> {
            return ResponseXFilter(this)
        }
    }


}