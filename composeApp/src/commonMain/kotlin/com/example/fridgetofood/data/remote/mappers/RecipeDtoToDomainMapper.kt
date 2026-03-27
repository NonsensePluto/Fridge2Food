package com.example.fridgetofood.data.remote.mappers

import com.example.fridgetofood.data.remote.dto.RecipeDto
import com.example.fridgetofood.domain.model.Recipe

class RecipeDtoToDomainMapper(
    private val ingredientDtoToDomainMapper: IngredientDtoToDomainMapper
) {
    operator fun invoke(recipeDto: RecipeDto) : Recipe {
        val ingredients = recipeDto.extendedIngredients?.map {
            ingredientDtoToDomainMapper(it)
        }
        return Recipe(
            id = recipeDto.id,
            title = recipeDto.title,
            imageUrl = recipeDto.imageUrl,
            ingredients = ingredients,
            instructions = recipeDto.instructions,
            readyInMinutes = recipeDto.readyInMinutes,
            usedIngredientCount = recipeDto.usedIngredientCount,
            missedIngredientCount = recipeDto.missedIngredientCount
        )
    }
}