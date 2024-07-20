package injection

import com.foodies.project.createDataStore
import com.foodies.project.getAppDatabase
import data.common.database.FoodiesAppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun localDataStorageModule(): Module = module {
    single { createDataStore(get()) }
    single<FoodiesAppDatabase> { getAppDatabase(get()) }
}