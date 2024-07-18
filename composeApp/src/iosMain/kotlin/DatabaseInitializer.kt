import data.common.database.FoodiesAppDatabase

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import data.common.database.instantiateImpl
import platform.Foundation.NSHomeDirectory

fun getAppDatabase(): FoodiesAppDatabase {
    val databaseFile = NSHomeDirectory() + "/foodies_app.db"
    return Room.databaseBuilder<FoodiesAppDatabase>(
        name = databaseFile,
        factory = { FoodiesAppDatabase::class.instantiateImpl()}
    ).setDriver(BundledSQLiteDriver()).build()
}
