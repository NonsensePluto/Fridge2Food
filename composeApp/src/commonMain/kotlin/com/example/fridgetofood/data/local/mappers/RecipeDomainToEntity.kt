package com.example.fridgetofood.data.local.mappers

import com.example.fridgetofood.data.local.entety.SavedRecipeEntity
import com.example.fridgetofood.domain.models.Recipe
import kotlinx.serialization.json.Json

class RecipeDomainToEntity {
    operator fun invoke(recipeModel: Recipe) : SavedRecipeEntity {
        val json = Json { ignoreUnknownKeys = true }
        return SavedRecipeEntity(
            id = recipeModel.id,
            title = recipeModel.title,
            imageUrl = recipeModel.imageUrl ?: "",
            ingredients = json.encodeToString(recipeModel.ingredients),
            instructions = recipeModel.instructions ?: "",
            readyInMinutes = recipeModel.readyInMinutes ?: 0,
            usedIngredientCount = recipeModel.usedIngredientCount ?: 0,
            missedIngredientCount = recipeModel.missedIngredientCount ?: 0,
            diets = recipeModel.diets?.let { json.encodeToString(it) },
            cuisines = recipeModel.cuisines?.let { json.encodeToString(it) }
        )
    }
}