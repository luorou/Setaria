package com.bye.ane.core.apiservice.di

import com.bye.ane.core.apiservice.index.IndexApi
import org.koin.dsl.module

val koinApiModule = module {
    single { IndexApi(get()) }
}