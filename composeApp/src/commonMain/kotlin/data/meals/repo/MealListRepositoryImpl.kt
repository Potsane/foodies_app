package data.meals.repo

import data.meals.source.remote.MealListService
import domain.meals.model.mappers.toMealList
import domain.meals.repository.MealListRepository
import presentation.base.Result
import domain.meals.model.Meal

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