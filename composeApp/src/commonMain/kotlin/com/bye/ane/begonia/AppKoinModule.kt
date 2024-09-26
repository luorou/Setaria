package com.bye.ane.begonia

import com.bye.ane.feature.computing.di.computingKoinModule
import org.koin.dsl.module

val appKoinModule = module {
    includes(computingKoinModule)
}