package com.bye.ane.core.apiservice.index

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class IndexApi(private val client: HttpClient) {
    suspend fun getIndex(): String {
        return client.get("https://www.baidu.com").body()
    }
}