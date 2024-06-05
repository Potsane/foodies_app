package data.source.remote

import data.source.remote.entity.Category
import data.source.remote.entity.CategoryResponse
import data.source.remote.entity.Ingredient
import data.source.remote.entity.IngredientsResponse
import data.source.remote.entity.Meal
import data.source.remote.entity.MealsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class FoodiesService(private val client: HttpClient) {

    suspend fun getCategories(): List<Category> {
        val response: CategoryResponse = client.get("categories.php").body()
        return response.categories
    }

    suspend fun getIngredients(): List<Ingredient> {
        val response: IngredientsResponse = client.get("list.php?i=list").body()
        return response.ingredients
    }

    suspend fun getMeals(page: Char): List<Meal> {
        val response: MealsResponse = client.get("search.php?f=$page").body()
        return response.meals
    }

    suspend fun lookUpMeal(
        id: String? = null,
        category: String? = null,
        ingredient: String? = null,
        area: String? = null,
        name: String? = null,
    ): List<Meal> {
        val searchQuery = when {
            id != null -> "lookup.php?i=$id"
            category != null -> "filter.php?c=$category"
            ingredient != null -> "filter.php?i=$ingredient"
            name != null -> "search.php?s=$name"
            area != null -> "filter.php?a=$area"
            else -> throw Exception("Search Criteria Not Provided")
        }

        val response: MealsResponse = client.get(searchQuery).body()
        return response.meals
    }
}