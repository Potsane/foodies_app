package data.mealist.repo

import data.mealist.source.remote.MealListService
import data.util.toMealList
import domain.meallist.repository.MealListRepository
import ui.base.Result
import domain.meallist.model.Meal

class MealListRepositoryImpl(
    private val service: MealListService
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