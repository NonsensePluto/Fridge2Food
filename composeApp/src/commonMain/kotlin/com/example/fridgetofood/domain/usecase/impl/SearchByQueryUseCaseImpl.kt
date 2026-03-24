package com.example.fridgetofood.domain.usecase.impl

import com.example.fridgetofood.domain.model.Recipe
import com.example.fridgetofood.domain.repository.ApiRepository
import com.example.fridgetofood.domain.usecase.SearchByQueryUseCase

class SearchByQueryUseCaseImpl(
    private val apiRepository: ApiRepository
) : SearchByQueryUseCase {

    override suspend fun invoke(
        query: String,
        number: Int,
        diet: String?,
        intolerances: String?,
        cuisine: String?,
        maxReadyTime: Int?
    ): List<Recipe> = apiRepository.searchByQuery(query, number, diet, intolerances, cuisine, maxReadyTime)
}