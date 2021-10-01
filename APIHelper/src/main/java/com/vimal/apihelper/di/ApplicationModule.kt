package com.vimal.apihelper.di

import android.util.Log
import com.vimal.apihelper.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Singleton
    @Provides
    fun httpClient(): HttpClient{
        return HttpClient(OkHttp){
            // Json
            install(JsonFeature) {
                serializer = KotlinxSerializer(json)
            }
            // Logging
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.v("Ktor", message)
                    }
                }
                level = LogLevel.ALL
            }
            // Timeout
            install(HttpTimeout) {
                requestTimeoutMillis = 15000L
                connectTimeoutMillis = 15000L
                socketTimeoutMillis = 15000L
            }
            // Apply to All Requests
            defaultRequest {
                host = BuildConfig.BASE_URL
                url {
                    protocol = URLProtocol.HTTP
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