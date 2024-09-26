package com.bye.ane.core.network.di

import android.util.Log
import com.bye.ane.core.global.UrlConfig
import com.bye.ane.core.network.plugin.AddHeaderPlugin
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver

private const val REQUEST_TIMEOUT_MILLIS = 10_000L
private const val SOCKET_TIMEOUT_SECONDS = 10_000L
private const val HTTP_CACHE_SIZE_BYTES = 1024 * 1024 * 50
private const val CONNECT_TIMEOUT_MILLIS = 10_000L

actual val ktorKoinModule = module {
    single<HttpClient> {
        val ktor = HttpClient(Android) {
            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
                url(UrlConfig.BASE_URL)
            }
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
            expectSuccess = true
            install(HttpTimeout) {
                requestTimeoutMillis = REQUEST_TIMEOUT_MILLIS
                connectTimeoutMillis = CONNECT_TIMEOUT_MILLIS
                socketTimeoutMillis = SOCKET_TIMEOUT_SECONDS
            }
            //
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.i("ktor", message)
                    }
                }
                level = LogLevel.ALL
            }
//            //
            install(ResponseObserver) {
                onResponse { response ->
                    Log.i("ktor-response", response.body<String>().toString())
                }
            }
//            //
            install(AddHeaderPlugin)
            //
        }
        ktor
    }
}