package ui.meallist

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import repo.meallist.MealListRepository
import ui.base.BaseViewModel

class MealListViewModel(private val mealListRepository: MealListRepository) : BaseViewModel() {

    init {
        viewModelScope.launch {
            mealListRepository.getMeals()
        }
    }
}