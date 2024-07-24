package domain.meals.repository

import presentation.base.Result
import domain.meals.model.Meal

interface MealListRepository {

    suspend fun getMeals(shouldRefreshData : Boolean = false) :List<Meal>
    suspend fun getMealsByCategory(category: String) : Result<List<Meal>>
}