package data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ui.model.Meal

@Dao
interface MealDao {

   @Insert
   suspend fun insert(meal: Meal)

 @Query("SELECT * FROM meal")
   suspend fun getAllMeals() : List <Meal>

   @Query("SELECT * FROM meal WHERE NAME=:name")
   suspend fun getMeal(name : String) : Meal
}
