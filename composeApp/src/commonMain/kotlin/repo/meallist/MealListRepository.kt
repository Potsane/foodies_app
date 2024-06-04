package repo.meallist

interface MealListRepository {

    suspend fun getMeals()
}