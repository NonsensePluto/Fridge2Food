package com.example.fridgetofood.domain.usecases.remote

import com.example.fridgetofood.domain.models.Recipe

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