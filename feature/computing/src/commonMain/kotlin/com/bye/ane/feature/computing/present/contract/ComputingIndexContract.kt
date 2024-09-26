package com.bye.ane.feature.computing.present.contract

import com.bye.ane.feature.computing.data.resp.ComputingConfigPO
import com.bye.ane.feature.computing.data.resp.ComputingProductPO

data class ComputingIndexState(
    val tabs: List<ComputingConfigPO> = emptyList(),
)

sealed class ComputingIndexEffect {
    data class ReplyComputingConfig(val result: List<ComputingConfigPO>) : ComputingIndexEffect()
}