package data.mealist.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import data.mealist.dto.MealDto

@Dao
interface MealDao {

   @Insert
   suspend fun insert(meal: MealDto)

 @Query("SELECT * FROM MealDto")
   suspend fun getAllMeals() : List <MealDto>

   @Query("SELECT * FROM MealDto WHERE NAME=:name")
   suspend fun getMeal(name : String) : MealDto
}
