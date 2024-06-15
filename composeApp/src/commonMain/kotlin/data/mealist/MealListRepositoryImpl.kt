package data.mealist

import data.source.remote.FoodiesService
import data.source.remote.entity.CategoryDto
import data.source.remote.entity.IngredientDto
import data.util.toMealList
import repo.meallist.MealListRepository
import ui.model.Meal

class MealListRepositoryImpl(
    private val service: FoodiesService
) : MealListRepository {

    override suspend fun getMeals() = getMealList()

    private suspend fun getCategories(): List<CategoryDto> {
        return service.getCategories()
    }

    private suspend fun getIngredients(): List<IngredientDto> {
        return service.getIngredients()
    }

    private suspend fun getMealList(): List<Meal>? {
        return service.getMeals('a').toMealList()
    }
}