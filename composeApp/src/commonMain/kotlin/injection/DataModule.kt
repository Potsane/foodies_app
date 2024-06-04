package injection

import data.source.remote.FoodiesClient
import data.source.remote.FoodiesService
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {
    single<HttpClient> {
        FoodiesClient()
            .host("themealdb.com")
            .build()
    }
    single<FoodiesService> { FoodiesService(get()) }
}