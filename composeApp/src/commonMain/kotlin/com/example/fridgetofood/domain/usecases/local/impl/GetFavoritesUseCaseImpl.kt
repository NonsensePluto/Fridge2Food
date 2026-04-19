package com.example.fridgetofood.domain.usecases.local.impl

import com.example.fridgetofood.domain.models.Recipe
import com.example.fridgetofood.domain.repositories.DatabaseRepository
import com.example.fridgetofood.domain.usecases.local.GetFavoritesUseCase
import kotlinx.coroutines.flow.Flow

class GetFavoritesUseCaseImpl(
    private val repository: DatabaseRepository
) : GetFavoritesUseCase {
    override operator fun invoke(): Flow<List<Recipe>> = repository.getFavorites()
}