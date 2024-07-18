package domain.meals.model.mappers

import data.meals.dto.CategoryDto
import domain.meals.model.Category

fun List<CategoryDto>?.toCategoryList(): List<Category>? {
    if (this == null) return null
    val categories = mutableListOf<Category>()
    this.map {
        val category = Category(it.id, it.name, it.imageUrl, it.description)
        categories.add(category)
    }
    return categories
}