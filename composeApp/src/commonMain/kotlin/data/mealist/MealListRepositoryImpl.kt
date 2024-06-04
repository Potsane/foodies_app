package data.mealist

import data.source.remote.FoodiesService
import data.source.remote.entity.Category
import repo.meallist.MealListRepository

class MealListRepositoryImpl(
    private val service: FoodiesService
) : MealListRepository {

    override suspend fun getMeals() {
        val categories = getCategories()
        println("-------------------- $categories --------------------")
    }

    private suspend fun getCategories(): List<Category> {
        return service.getCategories()
    }
}