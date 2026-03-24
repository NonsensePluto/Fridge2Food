package com.example.fridgetofood.domain.usecase

import com.example.fridgetofood.domain.model.Recipe

interface GetRandomRecipesUseCase {

    suspend operator fun invoke(
        limit: Int,
        diet: String?,
        intolerances: String?,
        cuisines: String?,
        maxReadyTime: Int?,
        includeIngredients: String?,
        excludeIngredients: String?
    ): List<Recipe>
}