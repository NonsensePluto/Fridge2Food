package com.example.fridgetofood.presentation.searchscreen

import com.example.fridgetofood.domain.usecase.remote.GetRandomRecipesUseCase
import com.example.fridgetofood.domain.usecase.remote.SearchByQueryUseCase

class SearchViewModel(
    private val getRandomRecipesUseCase: GetRandomRecipesUseCase,
    private val searchByQueryUseCase: SearchByQueryUseCase
) {

    suspend fun searchByQuery(
        query: String,
        number: Int = 10,
        diet: String? = null,
        intolerances: String? = null,
        cuisine: String? = null,
        maxReadyTime: Int? = null
    ) : List<com.example.fridgetofood.domain.model.Recipe> = searchByQueryUseCase(query, number, diet, intolerances, cuisine, maxReadyTime)
}