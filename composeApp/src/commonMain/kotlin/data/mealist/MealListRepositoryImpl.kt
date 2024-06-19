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
        return  service.getMeals('a').toMealList()
    }

    override suspend fun getMealsByCategory(category: String): Result<List<Meal>> {
        return Result.Success(data = emptyList())
    }
}