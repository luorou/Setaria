package com.bye.ane.core.network.di

import org.koin.dsl.module

val networkKoinModule = module {
    includes(ktorKoinModule)
}