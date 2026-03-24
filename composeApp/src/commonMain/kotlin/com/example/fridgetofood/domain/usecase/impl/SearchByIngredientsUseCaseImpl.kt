package com.example.fridgetofood.domain.usecase.impl

import com.example.fridgetofood.domain.model.Recipe
import com.example.fridgetofood.domain.repository.ApiRepository
import com.example.fridgetofood.domain.usecase.SearchByIngredientsUseCase

class SearchByIngredientsUseCaseImpl(
    private val apiRepository: ApiRepository
) : SearchByIngredientsUseCase {

    override suspend fun invoke(
        ingredients: String,
        number: Int,
        ignorePantry: Boolean
    ): List<Recipe> = apiRepository.searchByIngredients(ingredients, number, ignorePantry)
}