package injection

import com.foodies.project.createDataStore
import com.foodies.project.getAppDatabase
import data.common.database.FoodiesAppDatabase
import org.koin.dsl.module

actual val databaseModule = module {
    single<FoodiesAppDatabase> { getAppDatabase(get()) }
}
actual val dataStoreModule = module {
    single { createDataStore(get()) }
}
