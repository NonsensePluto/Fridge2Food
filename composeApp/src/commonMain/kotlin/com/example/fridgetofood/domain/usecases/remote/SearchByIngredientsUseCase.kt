package com.example.fridgetofood.domain.usecases.remote

import com.example.fridgetofood.domain.models.Recipe

interface SearchByIngredientsUseCase {

    suspend operator fun invoke(
        ingredients: String,
        number: Int,
        ignorePantry: Boolean
    ): List<Recipe>
}