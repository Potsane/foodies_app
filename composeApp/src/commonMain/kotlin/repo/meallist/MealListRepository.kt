package repo.meallist

import ui.model.Meal

interface MealListRepository {

    suspend fun getMeals() : List<Meal>?
    suspend fun getMealsByCategory(category: String) : List<Meal>?
}