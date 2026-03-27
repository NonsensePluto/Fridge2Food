package com.example.fridgetofood.domain.usecase.local.impl

import com.example.fridgetofood.domain.repository.DatabaseRepository
import com.example.fridgetofood.domain.usecase.local.IsFavoriteUseCase

class IsFavoriteUseCaseImpl(
    private val repository: DatabaseRepository
) : IsFavoriteUseCase {
    override suspend operator fun invoke(recipeId: Int): Boolean = repository.isFavorite(recipeId)
}