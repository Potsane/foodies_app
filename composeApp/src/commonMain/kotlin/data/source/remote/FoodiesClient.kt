package data.source.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class FoodiesClient {

    private lateinit var host: String

    fun host(host: String) = apply { this.host = host }

    fun build(): HttpClient {
        return HttpClient {

            defaultRequest {
                host = this@FoodiesClient.host
                url {
                    protocol = URLProtocol.HTTPS
                }
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