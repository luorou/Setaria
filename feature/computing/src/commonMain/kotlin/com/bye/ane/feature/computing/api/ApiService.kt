package com.bye.ane.feature.computing.api

import com.bye.ane.core.network.result.ResponseWrapper
import com.bye.ane.feature.computing.data.resp.BannerInfoPO
import com.bye.ane.feature.computing.data.resp.ComputingConfigPO
import com.bye.ane.feature.computing.data.resp.ComputingProductDetailPO
import com.bye.ane.feature.computing.data.resp.ComputingProductListResp
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class ApiService(private val client: HttpClient) {

    /**
     *
     */
    suspend fun computingConfig(): ResponseWrapper<List<ComputingConfigPO>> {
        return client.get("/app-api/system/power/get-config") {
        }.body()
    }

    /**
     *
     */
    suspend fun bannerInfoList(): ResponseWrapper<List<BannerInfoPO>> {
        return client.get("/app-api/promotion/banner-info/list") {
        }.body()
    }

    /**
     *
     */
    suspend fun computingProductList(params: Map<String, Any?>): ResponseWrapper<List<ComputingProductListResp>> {
        return client.post("/app-api/system/power/page") {
            setBody(params)
        }.body()
    }

    /**
     *
     */
    suspend fun computingDetail(params: Map<String, Any?>): ResponseWrapper<List<ComputingProductDetailPO>> {
        return client.get("/app-api/system/power/get") {
            setBody(params)
        }.body()
    }


//    /**
//     *
//     */
//    suspend fun fetchProductDetail(productId: String): ResponseWrapper<ProductDetailPO> {
//        return client.get("/app-api/product/spu/get-detail") {
//            parameter("productId", productId)
//        }.body()
//    }
}