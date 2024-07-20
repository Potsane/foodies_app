package injection

import createDataStore
import data.common.database.FoodiesAppDatabase
import getAppDatabase
import org.koin.dsl.module

actual val databaseModule = module {
    single<FoodiesAppDatabase> { getAppDatabase() }
}
actual val dataStoreModule = module {
    createDataStore()
}