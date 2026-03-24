package com.example.fridgetofood.data.remote.mappers

import com.example.fridgetofood.data.remote.dto.IngredientDto
import com.example.fridgetofood.domain.model.Ingredient

class IngredientDtoToDomainMapper {
    operator fun invoke(ingredientDto: IngredientDto): Ingredient {
        return Ingredient(
            id = ingredientDto.id,
            name = ingredientDto.name,
            original = ingredientDto.original ?: ingredientDto.name,
            amount = ingredientDto.amount ?: 0.0,
            unit = ingredientDto.unit ?: ""
        )
    }
}