package com.example.fridgetofood.domain.usecases.remote.impl

import com.example.fridgetofood.domain.models.Recipe
import com.example.fridgetofood.domain.repositories.ApiRepository
import com.example.fridgetofood.domain.usecases.remote.SearchByIngredientsUseCase

class SearchByIngredientsUseCaseImpl(
    private val apiRepository: ApiRepository
) : SearchByIngredientsUseCase {

    override suspend fun invoke(
        ingredients: String,
        number: Int,
        ignorePantry: Boolean
    ): List<Recipe> = apiRepository.searchByIngredients(ingredients, number, ignorePantry)
}