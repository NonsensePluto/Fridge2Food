package com.example.fridgetofood.domain.usecase

import com.example.fridgetofood.domain.model.Recipe

interface SearchByQueryUseCase {

    suspend operator fun invoke(
        query: String,
        number: Int,
        diet: String?,
        intolerances: String?,
        cuisine: String?,
        maxReadyTime: Int?
    ): List<Recipe>
}