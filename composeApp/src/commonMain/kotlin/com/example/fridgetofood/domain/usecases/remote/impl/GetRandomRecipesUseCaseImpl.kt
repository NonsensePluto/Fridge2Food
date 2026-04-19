package com.example.fridgetofood.domain.usecases.remote.impl

import com.example.fridgetofood.domain.models.Recipe
import com.example.fridgetofood.domain.repositories.ApiRepository
import com.example.fridgetofood.domain.usecases.remote.GetRandomRecipesUseCase

class GetRandomRecipesUseCaseImpl(
    private val apiRepository: ApiRepository
) : GetRandomRecipesUseCase {

    override suspend fun invoke(
        limit: Int,
        diet: String?,
        intolerances: String?,
        cuisines: String?,
        maxReadyTime: Int?,
        includeIngredients: String?,
        excludeIngredients: String?
    ): List<Recipe> = apiRepository.getRandomRecipes(limit, diet, intolerances, cuisines, maxReadyTime, includeIngredients, excludeIngredients)
}