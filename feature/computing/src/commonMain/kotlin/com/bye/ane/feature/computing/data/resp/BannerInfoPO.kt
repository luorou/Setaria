package com.bye.ane.feature.computing.data.resp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class BannerInfoPO(
    @SerialName("id")  val id: Long,
    @SerialName("name")  val name: String,
    @SerialName("picUrl")  val picUrl: String? = null,
)