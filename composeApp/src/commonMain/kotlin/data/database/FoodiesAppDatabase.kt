package data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import data.mealist.dto.MealDto
import data.mealist.source.local.MealDao

@Database(
    entities = [MealDto::class],
    version = 3
)
abstract class FoodiesAppDatabase : RoomDatabase(), DB {
    abstract fun mealDao(): MealDao
    override fun clearAllTables(): Unit {}
}

//Hack to get rid of Class 'AppDatabase_Impl' is not abstract and does not
//implement abstract base class member 'clearAllTables' error
//https://slack-chats.kotlinlang.org/t/18840650/do-you-guys-have-any-ideas-for-a-solution
interface DB {
    fun clearAllTables(): Unit {}
}
