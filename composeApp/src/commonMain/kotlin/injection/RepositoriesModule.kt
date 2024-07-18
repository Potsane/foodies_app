package injection

import data.meals.repo.MealListRepositoryImpl
import org.koin.dsl.module
import domain.meals.repository.MealListRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind

val repositoriesModule = module {
    singleOf(::MealListRepositoryImpl).bind(MealListRepository::class)
}