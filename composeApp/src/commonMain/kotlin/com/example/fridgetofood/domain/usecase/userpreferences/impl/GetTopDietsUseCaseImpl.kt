package com.example.fridgetofood.domain.usecase.userpreferences.impl

import com.example.fridgetofood.domain.repository.UserPreferencesRepository
import com.example.fridgetofood.domain.usecase.userpreferences.GetTopDietsUseCase

class GetTopDietsUseCaseImpl(
    private val repository: UserPreferencesRepository
) : GetTopDietsUseCase {

    override suspend fun invoke(limit: Int): List<String> {
        return repository.getTopDiets(limit).map{
            it.first
        }
    }
}