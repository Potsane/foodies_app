package injection

import data.mealist.repo.MealListRepositoryImpl
import org.koin.dsl.module
import domain.meallist.repository.MealListRepository

val repositoriesModule = module {
    single<MealListRepository> { MealListRepositoryImpl(get()) }
}