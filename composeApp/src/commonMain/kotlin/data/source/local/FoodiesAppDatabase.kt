package data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ui.model.Meal

@Database(
    entities = [Meal::class],
    version = 2
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
