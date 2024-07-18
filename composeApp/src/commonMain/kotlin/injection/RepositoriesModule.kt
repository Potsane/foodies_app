package injection

import data.meals.repo.MealListRepositoryImpl
import org.koin.dsl.module
import domain.meals.repository.MealListRepository

val repositoriesModule = module {
    single<MealListRepository> { MealListRepositoryImpl(get(),get()) }
}