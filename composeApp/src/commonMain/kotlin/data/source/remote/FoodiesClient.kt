package data.source.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class FoodiesClient {

    private lateinit var baseUrl: String

    fun host(baseUrl: String) = apply { this.baseUrl = baseUrl }

    fun build(): HttpClient {
        return HttpClient {

            defaultRequest {
                url(this@FoodiesClient.baseUrl)
            }

            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }
}