package com.example.fridgetofood.presentation.mappers

import com.example.fridgetofood.domain.models.Recipe
import com.example.fridgetofood.domain.repositories.DatabaseRepository
import com.example.fridgetofood.presentation.models.IngredientUi
import com.example.fridgetofood.presentation.models.RecipeUi

class RecipeDomainToUiMapper(
    private val repository: DatabaseRepository
) {

    suspend operator fun invoke(recipe: Recipe): RecipeUi {
        return RecipeUi(
            id = recipe.id,
            title = recipe.title,
            imageUrl = recipe.imageUrl,
            usedIngredientCount = recipe.usedIngredientCount,
            missedIngredientCount = recipe.missedIngredientCount,
            ingredients = recipe.ingredients?.map { ingredient ->
                IngredientUi(
                    id = ingredient.id,
                    name = ingredient.name,
                    original = ingredient.original,
                    amount = ingredient.amount,
                    unit = ingredient.unit,
                )
            },
            summary = recipe.summary,
            instructions = recipe.instructions,
            readyInMinutes = recipe.readyInMinutes,
            diets = recipe.diets,
            cuisines = recipe.cuisines,
            isFavorite = repository.isFavorite(recipe.id),
        )
    }

    suspend fun mapList(recipes: List<Recipe>): List<RecipeUi> {
        val favoriteIds = repository.getFavoriteIds()
        return recipes.map { recipe ->
            RecipeUi(
                id = recipe.id,
                title = recipe.title,
                imageUrl = recipe.imageUrl,
                usedIngredientCount = recipe.usedIngredientCount,
                missedIngredientCount = recipe.missedIngredientCount,
                ingredients = recipe.ingredients?.map { ingredient ->
                    IngredientUi(
                        id = ingredient.id,
                        name = ingredient.name,
                        original = ingredient.original,
                        amount = ingredient.amount,
                        unit = ingredient.unit,
                    )
                },
                summary = recipe.summary,
                instructions = recipe.instructions,
                readyInMinutes = recipe.readyInMinutes,
                diets = recipe.diets,
                cuisines = recipe.cuisines,
                isFavorite = favoriteIds.contains(recipe.id),
            )
        }
    }
}
