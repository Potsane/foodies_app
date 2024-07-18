package injection

import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import presentation.base.BaseViewModel
import presentation.ui.meals.MealListViewModel

val viewModelsModule = module {
    viewModelOf(::BaseViewModel)
    viewModelOf(::MealListViewModel)
}