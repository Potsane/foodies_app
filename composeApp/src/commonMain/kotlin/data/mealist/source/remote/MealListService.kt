package data.mealist.source.remote

import data.mealist.dto.CategoryDto
import data.mealist.dto.CategoryResponse
import data.mealist.dto.IngredientDto
import data.mealist.dto.IngredientsResponse
import data.mealist.dto.MealDto
import data.mealist.dto.MealsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MealListService(private val client: HttpClient) {

    suspend fun getCategories(): List<CategoryDto> {
        val response: CategoryResponse = client.get("categories.php").body()
        return response.categories
    }

    suspend fun getIngredients(): List<IngredientDto> {
        val response: IngredientsResponse = client.get("list.php?i=list").body()
        return response.ingredients
    }

    suspend fun getMeals(page: Char): List<MealDto> {
        val response: MealsResponse = client.get("search.php?f=$page").body()
        return response.meals
    }

    suspend fun lookUpMeal(
        id: String? = null,
        category: String? = null,
        ingredient: String? = null,
        area: String? = null,
        name: String? = null,
    ): List<MealDto> {
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