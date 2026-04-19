package com.example.fridgetofood.domain.usecases.local.impl

import com.example.fridgetofood.domain.repositories.DatabaseRepository
import com.example.fridgetofood.domain.usecases.local.IsFavoriteUseCase

class IsFavoriteUseCaseImpl(
    private val repository: DatabaseRepository
) : IsFavoriteUseCase {
    override suspend operator fun invoke(recipeId: Int): Boolean = repository.isFavorite(recipeId)
}