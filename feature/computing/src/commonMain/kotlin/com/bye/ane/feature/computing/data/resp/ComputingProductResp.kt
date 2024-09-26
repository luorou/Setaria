package com.bye.ane.feature.computing.data.resp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ComputingProductListResp(
    @SerialName("list") val list: List<ComputingProductPO>? = null,
    @SerialName("isLast") val isLast: Boolean = false,
    @SerialName("total") val total: Int? = null,
)

@Serializable
data class ComputingProductPO(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String? = null,
    @SerialName("power") val power: Long,
    @SerialName("period") val period: Long,
    @SerialName("price") val price: String,
    @SerialName("serviceFee") val serviceFee: String? = null,
    @SerialName("machineRight") val machineRight: Long,
    @SerialName("powerUnit") val powerUnit: String,
)

@Serializable
data class ComputingProductDetailPO(
    @SerialName("powerId") val powerId: Long,
    @SerialName("name") val name: String,
    @SerialName("power") val power: Long,
    @SerialName("period") val period: Long,
    @SerialName("price") val price: String,
    @SerialName("serviceFee") val serviceFee: String,
    @SerialName("machineRight") val machineRight: Long,
    @SerialName("point") val point: Long,
    @SerialName("effectDate") val effectDate: String? = null,
    @SerialName("productAdv") val productAdv: String? = null,
    @SerialName("propertyDesc") val propertyDesc: String? = null,
    @SerialName("riskWarning") val riskWarning: String? = null,
    @SerialName("transactionInstruc") val transactionInstruc: String? = null,
    @SerialName("powerUnit") val powerUnit: String
)