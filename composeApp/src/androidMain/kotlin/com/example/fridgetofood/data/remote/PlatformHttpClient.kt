package com.example.fridgetofood.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import io.github.aakira.napier.Napier
import kotlinx.serialization.json.Json

actual fun createHttpClient(): HttpClient {
    return HttpClient(Android) {
        engine {
            connectTimeout = 60_000
            socketTimeout = 120_000
        }
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true; isLenient = true })
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 120_000
            connectTimeoutMillis = 60_000
            socketTimeoutMillis = 120_000
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "KtorClient", message = message)
                }
            }
            level = LogLevel.HEADERS
        }
        defaultRequest {
            url("https://api.spoonacular.com")
        }
    }
}