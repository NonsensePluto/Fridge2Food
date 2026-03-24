package com.example.fridgetofood.domain.usecase

import com.example.fridgetofood.domain.model.Recipe

interface SearchByIngredientsUseCase {

    suspend operator fun invoke(
        ingredients: String,
        number: Int,
        ignorePantry: Boolean
    ): List<Recipe>
}