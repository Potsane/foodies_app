package injection

import data.FoodiesClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

val networkModule = module {
    single<HttpClient> {
        FoodiesClient()
            .host("www.themealdb.com/api/json/v1/1")
            .build()
    }
}