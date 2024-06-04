package injection

import org.koin.dsl.module
import ui.meallist.MealListViewModel

val viewModelsModule = module {
    factory { MealListViewModel(get()) }
}