package com.bye.ane.core.repository.di

import com.bye.ane.core.apiservice.index.IndexApi
import org.koin.dsl.module

val koinRepositoryModule = module {
    single { IndexApi(get()) }
}