package com.bye.ane.feature.computing.repository

import com.bye.ane.core.network.fliter.ResponseXFilter
import com.bye.ane.core.repository.filter.FailureInterceptorImpl
import com.bye.ane.core.repository.filter.ToastErrorMessageInterceptor
import com.bye.ane.feature.computing.api.ApiService
import com.bye.ane.feature.computing.data.resp.ComputingConfigPO

class Repository(private val api: ApiService) {

    /**
     *
     */
    suspend fun computingConfig(): List<ComputingConfigPO>? {
        val filter = ResponseXFilter.Builder<List<ComputingConfigPO>>()
            .addBusinessInterceptor(ToastErrorMessageInterceptor())
        kotlin.runCatching {
            api.computingConfig()
        }.onSuccess {
            filter.setResponse(it)
        }.onFailure {
            filter.setFailureInterceptor(FailureInterceptorImpl())
                .setException(it)
        }
        return filter.build().process()

    }
}