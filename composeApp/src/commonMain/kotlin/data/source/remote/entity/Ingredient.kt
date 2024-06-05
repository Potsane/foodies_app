package data.source.remote.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ingredient(
    @SerialName("idIngredient")
    val id : String,
    @SerialName("strIngredient")
    val name : String,
    @SerialName("strDescription")
    val description : String?,
    @SerialName("strType")
    val type : String?,
)

@Serializable
data class IngredientsResponse(
    @SerialName("meals")
    val ingredients : List<Ingredient>
)