package data.source.remote

import data.source.remote.entity.Category
import data.source.remote.entity.CategoryResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class FoodiesService(private val client: HttpClient) {

    suspend fun getCategories() : List<Category>{
        val response : CategoryResponse = client.get("/api/json/v1/1/categories.php").body()
        return response.categories
    }
}