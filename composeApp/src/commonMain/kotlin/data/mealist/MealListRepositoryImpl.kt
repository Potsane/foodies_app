package data.mealist

import data.source.remote.FoodiesService
import data.util.toMealList
import repo.meallist.MealListRepository
import ui.base.Result
import ui.model.Meal

class MealListRepositoryImpl(
    private val service: FoodiesService
) : MealListRepository {

    override suspend fun getMeals(): List<Meal> {
        val meals = mutableListOf<Meal>()
        val keys = "abcdefghijklmnoprstvwy".toCharArray() //no quxz
        keys.forEach {
            meals.addAll(service.getMeals(it).toMealList())
        }
        return meals
    }

    override suspend fun getMealsByCategory(category: String): Result<List<Meal>> {
        return Result.Success(data = emptyList())
    }
}