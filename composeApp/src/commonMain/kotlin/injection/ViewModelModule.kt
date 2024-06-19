package injection

import org.koin.dsl.module
import ui.base.BaseViewModel
import ui.meallist.MealListViewModel

val viewModelsModule = module {
    factory { MealListViewModel(get()) }
    factory { BaseViewModel() }
}