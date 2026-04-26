package com.example.fridgetofood.data.local.mappers

import com.example.fridgetofood.data.local.entety.SavedRecipeWithRelations
import com.example.fridgetofood.domain.models.Ingredient
import com.example.fridgetofood.domain.models.Recipe

class RecipeEntityToDomain {
    operator fun invoke(recipeWithRelations: SavedRecipeWithRelations): Recipe {
        return Recipe(
            id = recipeWithRelations.recipe.id,
            title = recipeWithRelations.recipe.title,
            imageUrl = recipeWithRelations.recipe.imageUrl,
            ingredients = recipeWithRelations.ingredients.map {
                Ingredient(
                    id = it.id,
                    name = it.name,
                )
            },
            instructions = recipeWithRelations.recipe.instructions,
            readyInMinutes = recipeWithRelations.recipe.readyInMinutes,
            usedIngredientCount = recipeWithRelations.recipe.usedIngredientCount,
            missedIngredientCount = recipeWithRelations.recipe.missedIngredientCount,
            diets = recipeWithRelations.diets.map { it.name },
            cuisines = recipeWithRelations.cuisines.map { it.name },
        )
    }
}