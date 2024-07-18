package injection

import org.koin.dsl.module
import presentation.base.BaseViewModel
import presentation.ui.meals.MealListViewModel

val viewModelsModule = module {
    factory { MealListViewModel(get()) }
    factory { BaseViewModel() }
}