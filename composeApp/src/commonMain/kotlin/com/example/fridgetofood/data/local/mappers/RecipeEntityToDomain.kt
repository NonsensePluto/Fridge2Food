package com.example.fridgetofood.data.local.mappers

import com.example.fridgetofood.data.local.entety.SavedRecipeEntity
import com.example.fridgetofood.domain.models.Ingredient
import com.example.fridgetofood.domain.models.Recipe
import kotlinx.serialization.json.Json

class RecipeEntityToDomain {
    operator fun invoke(recipeEntity: SavedRecipeEntity) : Recipe {
        val json = Json { ignoreUnknownKeys = true }
        val ingredients = json.decodeFromString<List<Ingredient>>(recipeEntity.ingredients)
        val diets = recipeEntity.diets?.let { json.decodeFromString<List<String>>(it) }
        val cuisines = recipeEntity.cuisines?.let { json.decodeFromString<List<String>>(it) }

        return Recipe(
            id = recipeEntity.id,
            title = recipeEntity.title,
            imageUrl = recipeEntity.imageUrl,
            ingredients = ingredients,
            instructions = recipeEntity.instructions,
            readyInMinutes = recipeEntity.readyInMinutes,
            usedIngredientCount = recipeEntity.usedIngredientCount,
            missedIngredientCount = recipeEntity.missedIngredientCount,
            diets = diets,
            cuisines = cuisines
        )
    }
}