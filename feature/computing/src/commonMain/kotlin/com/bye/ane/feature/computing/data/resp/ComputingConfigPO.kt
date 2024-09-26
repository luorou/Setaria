package com.bye.ane.feature.computing.data.resp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ComputingConfigPO(
    @SerialName("coinTypeLabel") val coinTypeLabel: String? = null,
    @SerialName("coinType") val coinType: String? = null,
    @SerialName("power") val power: List<Int>? = null,
    @SerialName("period") val period: List<Int>? = null
)