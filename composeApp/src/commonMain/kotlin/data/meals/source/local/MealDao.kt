package data.meals.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import data.meals.dto.MealDto

@Dao
interface MealDao {

    @Insert
    suspend fun insertMeal(meal: MealDto)

    @Query("DELETE FROM MealDto")
    suspend fun delete()

    @Insert
    suspend fun insertMeals(meals: List<MealDto>)

    @Transaction
    suspend fun clearAndInsert(meals: List<MealDto>){
        delete()
        insertMeals(meals)
    }

    @Query("SELECT * FROM MealDto")
    suspend fun getAllMeals(): List<MealDto>

    @Query("SELECT * FROM MealDto WHERE NAME=:name")
    suspend fun getMeal(name: String): MealDto
}
