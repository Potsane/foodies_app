package data.meals.repo

import data.common.database.FoodiesAppDatabase
import data.meals.dto.MealDto
import data.meals.source.remote.MealListService
import data.preferences.FoodieAppDataStore
import domain.meals.model.Meal
import domain.meals.model.mappers.toMealList
import domain.meals.repository.MealListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.Instant
import kotlinx.datetime.until
import presentation.base.Result

class MealListRepositoryImpl(
    private val service: MealListService,
    private val database: FoodiesAppDatabase,
    private val dataStore: FoodieAppDataStore
) : MealListRepository {

    override suspend fun getMeals(shouldRefreshData: Boolean): List<Meal> {
        val meals = mutableListOf<MealDto>()
        if (shouldRefreshData || isLocalDataInvalid()) {
            withContext(Dispatchers.IO) {
                meals.addAll(getRemoteMeals())
                saveMeals(meals)
            }
        } else {
            withContext(Dispatchers.IO) {
                meals.addAll(getLocalMeals())
            }
        }
        return meals.toMealList()
    }

    override suspend fun getMealsByCategory(category: String): Result<List<Meal>> {
        return Result.Success(data = emptyList())
    }

    private suspend fun getRemoteMeals(): List<MealDto> {
        val keys = "abcdefghijklmnoprstvwy".toCharArray() //no quxz
        val meals = coroutineScope {
            keys.map { key ->
                async { service.getMeals(key) }
            }.awaitAll()
        }
        return meals.flatten()
    }

    private suspend fun getLocalMeals(): List<MealDto> {
        return database.mealDao().getAllMeals()
    }

    private suspend fun saveMeals(meals: List<MealDto>) {
        database.mealDao().clearAndInsert(meals)
        val currentTime = Clock.System.now().toEpochMilliseconds()
        dataStore.updateDataPersistenceTime(currentTime)
    }

    private suspend fun isLocalDataInvalid(): Boolean {
        val saveTime =  dataStore.getDataPersistenceTime()
        val now = Clock.System.now()
        val diff = Instant.fromEpochMilliseconds(saveTime)
            .until(now, DateTimeUnit.TimeBased(3600_000_000_000))
        return diff > 24
    }
}
