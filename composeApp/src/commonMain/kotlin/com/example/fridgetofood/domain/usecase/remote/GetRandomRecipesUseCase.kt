package com.example.fridgetofood.domain.usecase.remote

import com.example.fridgetofood.domain.model.Recipe

interface GetRandomRecipesUseCase {

    suspend operator fun invoke(
        limit: Int =10,
        diet: String? = null,
        intolerances: String? = null,
        cuisines: String? = null,
        maxReadyTime: Int? = null,
        includeIngredients: String? = null,
        excludeIngredients: String? = null
    ): List<Recipe>
}