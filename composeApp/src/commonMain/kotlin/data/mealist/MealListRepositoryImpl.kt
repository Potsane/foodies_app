package data.mealist

import data.source.remote.FoodiesService
import data.source.remote.entity.Category
import data.source.remote.entity.Ingredient
import data.source.remote.entity.Meal
import repo.meallist.MealListRepository

class MealListRepositoryImpl(
    private val service: FoodiesService
) : MealListRepository {

    override suspend fun getMeals() {
        val meals = getMealList()
    }

    private suspend fun getCategories(): List<Category> {
        return service.getCategories()
    }

    private suspend fun getIngredients() : List<Ingredient>{
        return service.getIngredients()
    }

    private suspend fun getMealList() : List<Meal>{
        return service.getMeals('a')
    }
}