package data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class FoodiesClient {

    private lateinit var host: String

    fun host(host: String) = apply { this.host = host }

    fun build() : HttpClient{
        return HttpClient {

            defaultRequest {
                url {
                    protocol = URLProtocol.HTTP
                    host = this@FoodiesClient.host
                }
                header(HttpHeaders.ContentType, "application/json")
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