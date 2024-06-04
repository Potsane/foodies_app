package injection

import data.mealist.MealListRepositoryImpl
import org.koin.dsl.module
import repo.meallist.MealListRepository

val repositoriesModule = module {
    single<MealListRepository> { MealListRepositoryImpl(get()) }
}