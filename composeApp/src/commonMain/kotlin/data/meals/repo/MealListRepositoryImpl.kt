package data.meals.repo

import data.common.database.FoodiesAppDatabase
import data.meals.dto.MealDto
import data.meals.source.remote.MealListService
import domain.meals.model.mappers.toMealList
import domain.meals.repository.MealListRepository
import presentation.base.Result
import domain.meals.model.Meal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async

class MealListRepositoryImpl(
    private val service: MealListService,
    private val database: FoodiesAppDatabase
) : MealListRepository {

    private val scope = CoroutineScope(Dispatchers.IO)

    override suspend fun getMeals(): List<Meal> {
        val meals = mutableListOf<MealDto>()
        val keys = "abcdefghijklmnoprstvwy".toCharArray() //no quxz
        scope.async {
            keys.forEach {
                meals.addAll(service.getMeals(it))
            }
        }.await()
        saveMeals(meals)
        return meals.toMealList()
    }

    override suspend fun getMealsByCategory(category: String): Result<List<Meal>> {
        return Result.Success(data = emptyList())
    }

    private suspend fun saveMeals(meals: List<MealDto>) {
        database.mealDao().clearAndInsert(meals)
    }
}