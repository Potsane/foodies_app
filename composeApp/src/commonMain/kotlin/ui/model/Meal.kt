package ui.model

data class Meal(
    val id: String,
    val name: String,
    val category: String,
    val area: String,
    val instructions: String,
    val imageUrl: String,
    val tags: String?,
    val videoUrl: String,
    val ingredients: Map<String, String>
)