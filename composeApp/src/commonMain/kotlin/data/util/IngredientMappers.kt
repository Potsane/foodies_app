package data.util

import data.source.remote.entity.IngredientDto
import ui.model.Ingredient

fun List<IngredientDto>?.toIngredientList(): List<Ingredient>? {
    if (this == null) return null
    val ingredients = mutableListOf<Ingredient>()
    this.map {
        ingredients.add(Ingredient(it.id, it.name, it.description, it.type))
    }
    return ingredients
}