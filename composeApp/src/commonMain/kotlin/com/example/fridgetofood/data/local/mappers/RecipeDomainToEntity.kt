package com.example.fridgetofood.data.local.mappers

import com.example.fridgetofood.data.local.entety.CuisineEntity
import com.example.fridgetofood.data.local.entety.DietEntity
import com.example.fridgetofood.data.local.entety.IngredientEntity
import com.example.fridgetofood.data.local.entety.RecipeCuisineCrossRef
import com.example.fridgetofood.data.local.entety.RecipeDietCrossRef
import com.example.fridgetofood.data.local.entety.RecipeIngredientCrossRef
import com.example.fridgetofood.data.local.entety.SavedRecipeEntity
import com.example.fridgetofood.domain.models.Recipe

data class RecipeStorageBundle(
    val recipe: SavedRecipeEntity,
    val ingredients: List<IngredientEntity>,
    val diets: List<DietEntity>,
    val cuisines: List<CuisineEntity>,
    val ingredientCrossRefs: List<RecipeIngredientCrossRef>,
    val dietCrossRefs: List<RecipeDietCrossRef>,
    val cuisineCrossRefs: List<RecipeCuisineCrossRef>,
)

class RecipeDomainToEntity {
    operator fun invoke(recipeModel: Recipe): RecipeStorageBundle {
        val recipeEntity = SavedRecipeEntity(
            id = recipeModel.id,
            title = recipeModel.title,
            imageUrl = recipeModel.imageUrl ?: "",
            instructions = recipeModel.instructions ?: "",
            readyInMinutes = recipeModel.readyInMinutes ?: 0,
            usedIngredientCount = recipeModel.usedIngredientCount ?: 0,
            missedIngredientCount = recipeModel.missedIngredientCount ?: 0,
        )

        val ingredients = recipeModel.ingredients.orEmpty().map {
            IngredientEntity(
                id = it.id,
                name = it.name,
            )
        }

        val diets = recipeModel.diets.orEmpty().map { DietEntity(name = it) }
        val cuisines = recipeModel.cuisines.orEmpty().map { CuisineEntity(name = it) }

        val ingredientCrossRefs = ingredients.map {
            RecipeIngredientCrossRef(
                recipeId = recipeModel.id,
                ingredientId = it.id,
            )
        }

        val dietCrossRefs = diets.map {
            RecipeDietCrossRef(
                recipeId = recipeModel.id,
                dietName = it.name,
            )
        }

        val cuisineCrossRefs = cuisines.map {
            RecipeCuisineCrossRef(
                recipeId = recipeModel.id,
                cuisineName = it.name,
            )
        }

        return RecipeStorageBundle(
            recipe = recipeEntity,
            ingredients = ingredients,
            diets = diets,
            cuisines = cuisines,
            ingredientCrossRefs = ingredientCrossRefs,
            dietCrossRefs = dietCrossRefs,
            cuisineCrossRefs = cuisineCrossRefs,
        )
    }
}