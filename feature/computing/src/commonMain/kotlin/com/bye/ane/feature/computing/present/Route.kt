@file:OptIn(KoinExperimentalAPI::class)

package com.bye.ane.feature.computing.present

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bye.ane.feature.computing.data.resp.ComputingConfigPO
import com.bye.ane.feature.computing.present.slice.ComputingChildSlice
import com.bye.ane.feature.computing.present.slice.ComputingIndexSlice
import com.bye.ane.feature.computing.present.vm.ComputingIndexVM
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI


@Composable
fun ComputingIndexSliceRoute(
    navController: NavHostController,
    calculateTopPadding: Dp = 32.dp,
    viewModel: ComputingIndexVM = koinViewModel()
) {

    viewModel.computingConfig()
    ComputingIndexSlice(navController, viewModel, calculateTopPadding)
}


@Composable
fun ComputingChildSliceRoute(
    label: ComputingConfigPO,
    viewModel: ComputingIndexVM = koinViewModel(key = label.coinType.toString())
) {
    //
    viewModel.computingConfig()
    ComputingChildSlice(label, viewModel)
}


