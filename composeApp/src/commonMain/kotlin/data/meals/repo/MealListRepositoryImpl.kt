package data.meals.repo

import data.common.database.FoodiesAppDatabase
import data.meals.dto.MealDto
import data.meals.source.remote.MealListService
import data.preferences.FoodieAppDataStore
import domain.meals.model.Meal
import domain.meals.model.mappers.toMealList
import domain.meals.repository.MealListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.datetime.Clock
import presentation.base.Result

class MealListRepositoryImpl(
    private val service: MealListService,
    private val database: FoodiesAppDatabase,
    private val dataStore: FoodieAppDataStore
) : MealListRepository {

    private val scope = CoroutineScope(Dispatchers.IO)

    override suspend fun getMeals(refresh: Boolean): List<Meal> {
        val meals = mutableListOf<MealDto>()
        if (refresh) {
            scope.async {
                meals.addAll(getRemoteMeals())
            }.await()
            saveMeals(meals)
        } else {
            meals.addAll(getLocalMeals())
        }

        return meals.toMealList()
    }

    override suspend fun getMealsByCategory(category: String): Result<List<Meal>> {
        return Result.Success(data = emptyList())
    }

    private suspend fun getRemoteMeals(): List<MealDto> {
        val meals = mutableListOf<MealDto>()
        val keys = "abcdefghijklmnoprstvwy".toCharArray() //no quxz
        keys.forEach {
            meals.addAll(service.getMeals(it))
        }
        return meals
    }

    private suspend fun getLocalMeals(): List<MealDto> {
        return database.mealDao().getAllMeals()
    }

    private suspend fun saveMeals(meals: List<MealDto>) {
        database.mealDao().clearAndInsert(meals)
        val currentTime = Clock.System.now().toEpochMilliseconds()
        dataStore.updateDataPersistenceTime(currentTime)
    }
}
