package presentation.ui.meals

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import domain.meals.repository.MealListRepository
import presentation.base.BaseViewModel
import presentation.base.Result
import domain.meals.model.Meal

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