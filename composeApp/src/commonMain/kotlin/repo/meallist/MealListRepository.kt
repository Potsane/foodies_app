package repo.meallist

import ui.base.Result
import ui.model.Meal

interface MealListRepository {

    suspend fun getMeals() :List<Meal>
    suspend fun getMealsByCategory(category: String) : Result<List<Meal>>
}