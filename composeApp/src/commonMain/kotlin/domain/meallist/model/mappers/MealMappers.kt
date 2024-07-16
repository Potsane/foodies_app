package domain.meallist.model.mappers

import data.mealist.dto.MealDto
import domain.meallist.model.Meal

fun List<MealDto>?.toMealList(): List<Meal> {
    if (this == null) throw NullServerResponseException()
    val meals = mutableListOf<Meal>()
    this.map {
        meals.add(
            Meal(
                it.id,
                it.name,
                it.category,
                it.area,
                it.instructions,
                it.imageUrl,
                it.tags,
                it.videoUrl,
                crateIngredientsMap(it)
            )
        )
    }
    return meals
}

//TODO - This needs to be improved, seriously!
private fun crateIngredientsMap(dto: MealDto): Map<String, String> {
    val ingredientsMap = mutableMapOf<String, String>()
    dto.apply {
        if (!ingredient1.isNullOrEmpty() && !measurement1.isNullOrEmpty()) ingredientsMap[ingredient1] = measurement1
        if (!ingredient2.isNullOrEmpty() && !measurement2.isNullOrEmpty()) ingredientsMap[ingredient2] = measurement2
        if (!ingredient3.isNullOrEmpty() && !measurement3.isNullOrEmpty()) ingredientsMap[ingredient3] = measurement3
        if (!ingredient4.isNullOrEmpty() && !measurement4.isNullOrEmpty()) ingredientsMap[ingredient4] = measurement4
        if (!ingredient5.isNullOrEmpty() && !measurement5.isNullOrEmpty()) ingredientsMap[ingredient5] = measurement5
        if (!ingredient6.isNullOrEmpty() && !measurement6.isNullOrEmpty()) ingredientsMap[ingredient6] = measurement6
        if (!ingredient7.isNullOrEmpty() && !measurement7.isNullOrEmpty()) ingredientsMap[ingredient7] = measurement7
        if (!ingredient8.isNullOrEmpty() && !measurement8.isNullOrEmpty()) ingredientsMap[ingredient8] = measurement8
        if (!ingredient9.isNullOrEmpty() && !measurement9.isNullOrEmpty()) ingredientsMap[ingredient9] = measurement9
        if (!ingredient10.isNullOrEmpty() && !measurement10.isNullOrEmpty()) ingredientsMap[ingredient10] = measurement10
        if (!ingredient11.isNullOrEmpty() && !measurement11.isNullOrEmpty()) ingredientsMap[ingredient11] = measurement11
        if (!ingredient12.isNullOrEmpty() && !measurement12.isNullOrEmpty()) ingredientsMap[ingredient12] = measurement12
        if (!ingredient13.isNullOrEmpty() && !measurement13.isNullOrEmpty()) ingredientsMap[ingredient13] = measurement13
        if (!ingredient14.isNullOrEmpty() && !measurement14.isNullOrEmpty()) ingredientsMap[ingredient14] = measurement14
        if (!ingredient15.isNullOrEmpty() && !measurement15.isNullOrEmpty()) ingredientsMap[ingredient15] = measurement15
        if (!ingredient16.isNullOrEmpty() && !measurement16.isNullOrEmpty()) ingredientsMap[ingredient16] = measurement16
        if (!ingredient17.isNullOrEmpty() && !measurement17.isNullOrEmpty()) ingredientsMap[ingredient17] = measurement17
        if (!ingredient18.isNullOrEmpty() && !measurement18.isNullOrEmpty()) ingredientsMap[ingredient18] = measurement18
        if (!ingredient19.isNullOrEmpty() && !measurement19.isNullOrEmpty()) ingredientsMap[ingredient19] = measurement19
        if (!ingredient20.isNullOrEmpty() && !measurement20.isNullOrEmpty()) ingredientsMap[ingredient20] = measurement20
    }
    return ingredientsMap
}