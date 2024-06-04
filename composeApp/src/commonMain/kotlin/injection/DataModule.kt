package injection

import data.source.remote.FoodiesClient
import data.source.remote.FoodiesService
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {
    single<HttpClient> {
        FoodiesClient()
            .host("https://www.themealdb.com/api/json/v1/1")
            .build()
    }
    single<FoodiesService> { FoodiesService(get()) }
}