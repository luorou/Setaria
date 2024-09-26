package com.bye.ane.begonia

import android.app.Application
import org.koin.core.context.startKoin

class SetariaApp :Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appKoinModule)
        }
    }
}