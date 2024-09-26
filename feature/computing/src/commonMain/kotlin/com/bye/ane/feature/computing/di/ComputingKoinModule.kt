package com.bye.ane.feature.computing.di

import com.bye.ane.core.network.di.networkKoinModule
import com.bye.ane.feature.computing.api.ApiService
import com.bye.ane.feature.computing.present.vm.ComputingChildVM
import com.bye.ane.feature.computing.present.vm.ComputingIndexVM
import com.bye.ane.feature.computing.repository.Repository
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val computingKoinModule = module {
    includes(networkKoinModule)
    single { ApiService(get()) }
    single { Repository(get()) }
    viewModel { ComputingIndexVM(get()) }
    viewModel { ComputingChildVM(get()) }
}