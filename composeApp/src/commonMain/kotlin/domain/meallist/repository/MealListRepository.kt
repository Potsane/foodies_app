package domain.meallist.repository

import ui.base.Result
import domain.meallist.model.Meal

interface MealListRepository {

    suspend fun getMeals() :List<Meal>
    suspend fun getMealsByCategory(category: String) : Result<List<Meal>>
}