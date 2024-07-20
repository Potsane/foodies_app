package injection

import createDataStore
import data.common.database.FoodiesAppDatabase
import getAppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun localDataStorageModule(): Module = module {
    single { createDataStore() }
    single<FoodiesAppDatabase> { getAppDatabase() }
}