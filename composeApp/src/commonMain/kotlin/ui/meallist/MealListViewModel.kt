package ui.meallist

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import domain.meallist.repository.MealListRepository
import ui.base.BaseViewModel
import ui.base.Result
import domain.meallist.model.Meal

class MealListViewModel(private val mealListRepository: MealListRepository) : BaseViewModel() {

    private val _meals = MutableStateFlow<Result<List<Meal>>>(Result.Loading)
    val meals: StateFlow<Result<List<Meal>>> = _meals

    init{
        withProgress(_meals){
            mealListRepository.getMeals()
        }
    }

    fun getMealsByCategory(category: String) {
    }
}