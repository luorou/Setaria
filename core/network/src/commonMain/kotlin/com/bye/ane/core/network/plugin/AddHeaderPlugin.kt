package com.bye.ane.core.network.plugin

import io.ktor.client.plugins.api.createClientPlugin

val AddHeaderPlugin = createClientPlugin("AddHeaderPlugin") {

    onRequest { request, content ->
        request.headers.append("Authorization", "Bearer 1234567890")
    }

}