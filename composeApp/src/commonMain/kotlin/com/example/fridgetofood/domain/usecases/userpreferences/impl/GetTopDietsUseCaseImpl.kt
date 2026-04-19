package com.example.fridgetofood.domain.usecases.userpreferences.impl

import com.example.fridgetofood.domain.repositories.UserPreferencesRepository
import com.example.fridgetofood.domain.usecases.userpreferences.GetTopDietsUseCase

class GetTopDietsUseCaseImpl(
    private val repository: UserPreferencesRepository
) : GetTopDietsUseCase {

    override suspend fun invoke(limit: Int): List<String> {
        return repository.getTopDiets(limit).map{
            it.first
        }
    }
}