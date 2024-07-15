package injection

import data.client.FoodiesAppClient
import data.mealist.source.remote.MealListService
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule = module {
    single<HttpClient> {
        FoodiesAppClient()
            .host(baseUrl = "https://www.themealdb.com/api/json/v1/1/")
            .build()
    }
    single<MealListService> { MealListService(get()) }
}

expect fun dbModule() :  Module
