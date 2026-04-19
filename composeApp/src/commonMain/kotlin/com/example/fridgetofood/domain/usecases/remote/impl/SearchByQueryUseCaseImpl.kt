package com.example.fridgetofood.domain.usecases.remote.impl

import com.example.fridgetofood.domain.models.Recipe
import com.example.fridgetofood.domain.repositories.ApiRepository
import com.example.fridgetofood.domain.usecases.remote.SearchByQueryUseCase

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