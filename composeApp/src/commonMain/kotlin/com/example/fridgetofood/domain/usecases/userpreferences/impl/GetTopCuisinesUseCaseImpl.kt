package com.example.fridgetofood.domain.usecases.userpreferences.impl

import com.example.fridgetofood.domain.repositories.UserPreferencesRepository
import com.example.fridgetofood.domain.usecases.userpreferences.GetTopCuisinesUseCase

class GetTopCuisinesUseCaseImpl(
    private val repository: UserPreferencesRepository
) : GetTopCuisinesUseCase {

    override suspend fun invoke(limit: Int): List<String> {
        return repository.getTopDiets(limit).map{
            it.first
        }
    }
}