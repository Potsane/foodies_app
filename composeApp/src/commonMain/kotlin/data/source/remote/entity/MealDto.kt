package data.source.remote.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * TODO - We need to find a way to parse these
 * ingredients and measures to a hash map.
 **/
@Serializable
data class MealDto(
    @SerialName("idMeal")
    val id: String,

    @SerialName("strMeal")
    val name: String,

    @SerialName("strCategory")
    val category: String,

    @SerialName("strArea")
    val area: String,

    @SerialName("strInstructions")
    val instructions: String,

    @SerialName("strMealThumb")
    val imageUrl: String,

    @SerialName("strTags")
    val tags: String?,

    @SerialName("strYoutube")
    val videoUrl: String,

    // Ingredients

    @SerialName("strIngredient1")
    val ingredient1: String?,

    @SerialName("strIngredient2")
    val ingredient2: String?,

    @SerialName("strIngredient3")
    val ingredient3: String?,

    @SerialName("strIngredient4")
    val ingredient4: String?,

    @SerialName("strIngredient5")
    val ingredient5: String?,

    @SerialName("strIngredient6")
    val ingredient6: String?,

    @SerialName("strIngredient7")
    val ingredient7: String?,

    @SerialName("strIngredient8")
    val ingredient8: String?,

    @SerialName("strIngredient9")
    val ingredient9: String?,

    @SerialName("strIngredient10")
    val ingredient10: String?,

    @SerialName("strIngredient11")
    val ingredient11: String?,

    @SerialName("strIngredient12")
    val ingredient12: String?,

    @SerialName("strIngredient13")
    val ingredient13: String?,

    @SerialName("strIngredient14")
    val ingredient14: String?,

    @SerialName("strIngredient15")
    val ingredient15: String?,

    @SerialName("strIngredient16")
    val ingredient16: String?,

    @SerialName("strIngredient17")
    val ingredient17: String?,

    @SerialName("strIngredient18")
    val ingredient18: String?,

    @SerialName("strIngredient19")
    val ingredient19: String?,

    @SerialName("strIngredient20")
    val ingredient20: String?,

    // Measurements

    @SerialName("strMeasure1")
    val measurement1: String?,

    @SerialName("strMeasure2")
    val measurement2: String?,

    @SerialName("strMeasure3")
    val measurement3: String?,

    @SerialName("strMeasure4")
    val measurement4: String?,

    @SerialName("strMeasure5")
    val measurement5: String?,

    @SerialName("strMeasure6")
    val measurement6: String?,

    @SerialName("strMeasure7")
    val measurement7: String?,

    @SerialName("strMeasure8")
    val measurement8: String?,

    @SerialName("strMeasure9")
    val measurement9: String?,

    @SerialName("strMeasure10")
    val measurement10: String?,

    @SerialName("strMeasure11")
    val measurement11: String?,

    @SerialName("strMeasure12")
    val measurement12: String?,

    @SerialName("strMeasure13")
    val measurement13: String?,

    @SerialName("strMeasure14")
    val measurement14: String?,

    @SerialName("strMeasure15")
    val measurement15: String?,

    @SerialName("strMeasure16")
    val measurement16: String?,

    @SerialName("strMeasure17")
    val measurement17: String?,

    @SerialName("strMeasure18")
    val measurement18: String?,

    @SerialName("strMeasure19")
    val measurement19: String?,

    @SerialName("strMeasure20")
    val measurement20: String?,
)

@Serializable
data class MealsResponse(@SerialName("meals") val meals: List<MealDto>)