package injection

import data.database.FoodiesAppDatabase
import getAppDatabase
import org.koin.dsl.module

actual fun dbModule() = module {
    single<FoodiesAppDatabase> { getAppDatabase() }
}
