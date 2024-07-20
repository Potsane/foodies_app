package injection

import data.common.client.FoodiesAppClient
import data.meals.source.remote.MealListService
import data.preferences.FoodieAppDataStore
import data.preferences.FoodieAppDataStoreImpl
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteDataModule = module {
    single<HttpClient> {
        FoodiesAppClient()
            .host(baseUrl = "https://www.themealdb.com/api/json/v1/1/")
            .build()
    }
    singleOf(::MealListService)
}

val localDataModule = module{
    singleOf(::FoodieAppDataStoreImpl).bind(FoodieAppDataStore::class)
}

expect fun localDataStorageModule(): Module
