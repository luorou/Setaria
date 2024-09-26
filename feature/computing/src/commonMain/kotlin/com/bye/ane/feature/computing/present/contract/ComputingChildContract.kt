package com.bye.ane.feature.computing.present.contract

import com.bye.ane.feature.computing.data.resp.ComputingConfigPO
import com.bye.ane.feature.computing.data.resp.ComputingProductPO

data class ComputingChildState(
    val products: List<ComputingProductPO> = emptyList(),
)

sealed class ComputingChildEffect {
    data class ReplyComputingProducts(val result: List<ComputingConfigPO>) : ComputingIndexEffect()
}