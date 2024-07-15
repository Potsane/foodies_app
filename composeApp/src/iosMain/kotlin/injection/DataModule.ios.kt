package injection

import data.source.local.FoodiesAppDatabase
import getAppDatabase
import org.koin.dsl.module

actual fun dbModule() = module {
    single<FoodiesAppDatabase> { getAppDatabase() }
}
