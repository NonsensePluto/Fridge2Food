package com.example.fridgetofood.data.local.mappers

import com.example.fridgetofood.data.local.entety.SavedRecipeEntity
import com.example.fridgetofood.domain.model.Ingredient
import com.example.fridgetofood.domain.model.Recipe
import kotlinx.serialization.json.Json

class RecipeEntityToDomain {
    operator fun invoke(recipeEntity: SavedRecipeEntity) : Recipe {
        val json = Json { ignoreUnknownKeys = true }
        val ingredients = json.decodeFromString<List<Ingredient>>(recipeEntity.ingredients)
        return Recipe(
            id = recipeEntity.id,
            title = recipeEntity.title,
            imageUrl = recipeEntity.imageUrl,
            ingredients = ingredients,
            instructions = recipeEntity.instructions,
            readyInMinutes = recipeEntity.readyInMinutes,
            usedIngredientCount = recipeEntity.usedIngredientCount,
            missedIngredientCount = recipeEntity.missedIngredientCount
        )
    }
}