package ui.meallist

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import repo.meallist.MealListRepository
import ui.base.BaseViewModel
import ui.model.Meal

class MealListViewModel(private val mealListRepository: MealListRepository) : BaseViewModel() {

    private val _meals = MutableStateFlow(listOf<Meal>())
    val meals: StateFlow<List<Meal>> = _meals

    init {
        viewModelScope.launch {
            mealListRepository.getMeals()?.let {
                _meals.value = it
            }
        }
    }
}