package com.vimal.apihelper.di

import com.vimal.apihelper.constants.APIConfigs
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

class ApplicationModule {

    fun httpClient(): HttpClient {
        return HttpClient() {
            // Json
            install(JsonFeature) {
                serializer = KotlinxSerializer(json)
            }
            // Logging
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.HEADERS
            }
            // Timeout
            install(HttpTimeout) {
                requestTimeoutMillis = 15000L
                connectTimeoutMillis = 15000L
                socketTimeoutMillis = 15000L
            }
            // Apply to All Requests
            defaultRequest {
                host = APIConfigs.URL
                url {
                    protocol = APIConfigs.URLProtocol
                }
//                header("key","value")
//                parameter("api_key", "some_api_key")

                // Content Type
                if (this.method != HttpMethod.Get) contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
            // Optional OkHttp Interceptors
            engine {
//                addInterceptor(CurlInterceptor(Loggable { Log.v("Curl", it) }))
            }
        }
    }
}

private val json = Json {
    ignoreUnknownKeys = true
    isLenient = true
    encodeDefaults = false
}