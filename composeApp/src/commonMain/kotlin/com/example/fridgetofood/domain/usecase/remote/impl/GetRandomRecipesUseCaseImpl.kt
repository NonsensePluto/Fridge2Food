package com.example.fridgetofood.domain.usecase.remote.impl

import com.example.fridgetofood.domain.model.Recipe
import com.example.fridgetofood.domain.repository.ApiRepository
import com.example.fridgetofood.domain.usecase.remote.GetRandomRecipesUseCase

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