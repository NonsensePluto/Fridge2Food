package com.example.fridgetofood.domain.usecase.userpreferences.impl

import com.example.fridgetofood.domain.repository.UserPreferencesRepository
import com.example.fridgetofood.domain.usecase.userpreferences.GetTopCuisinesUseCase

class GetTopCuisinesUseCaseImpl(
    private val repository: UserPreferencesRepository
) : GetTopCuisinesUseCase {

    override suspend fun invoke(limit: Int): List<String> {
        return repository.getTopDiets(limit).map{
            it.first
        }
    }
}