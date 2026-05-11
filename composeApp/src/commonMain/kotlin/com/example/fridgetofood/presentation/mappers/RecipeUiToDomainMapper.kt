package com.example.fridgetofood.presentation.mappers

import com.example.fridgetofood.domain.models.Ingredient
import com.example.fridgetofood.domain.models.Recipe
import com.example.fridgetofood.presentation.models.RecipeUi

class RecipeUiToDomainMapper {

    operator fun invoke(recipeUi: RecipeUi): Recipe {
        return Recipe(
            id = recipeUi.id,
            title = recipeUi.title,
            imageUrl = recipeUi.imageUrl,
            usedIngredientCount = recipeUi.usedIngredientCount,
            missedIngredientCount = recipeUi.missedIngredientCount,
            ingredients = recipeUi.ingredients?.map { ingredientUi ->
                Ingredient(
                    id = ingredientUi.id,
                    name = ingredientUi.name,
                    original = ingredientUi.original,
                    amount = ingredientUi.amount,
                    unit = ingredientUi.unit,
                )
            },
            instructions = recipeUi.instructions,
            readyInMinutes = recipeUi.readyInMinutes,
            diets = recipeUi.diets,
            cuisines = recipeUi.cuisines,
        )
    }
}
