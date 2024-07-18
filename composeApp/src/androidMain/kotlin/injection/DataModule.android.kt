package injection

import com.foodies.project.getAppDatabase
import data.common.database.FoodiesAppDatabase
import org.koin.dsl.module

actual fun dbModule() = module {
    single<FoodiesAppDatabase> { getAppDatabase(get()) }
}
