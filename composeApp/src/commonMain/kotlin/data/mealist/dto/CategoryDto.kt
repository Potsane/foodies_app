package data.mealist.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryDto(
    @SerialName("idCategory")
    val id: String,

    @SerialName("strCategory")
    val name: String,

    @SerialName("strCategoryThumb")
    val imageUrl: String,

    @SerialName("strCategoryDescription")
    val description: String,
)

@Serializable
data class CategoryResponse(
    @SerialName("categories")
    val categories : List<CategoryDto>
)