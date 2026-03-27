package com.example.fridgetofood.domain.usecase.local.impl

import com.example.fridgetofood.domain.model.Recipe
import com.example.fridgetofood.domain.repository.DatabaseRepository
import com.example.fridgetofood.domain.usecase.local.GetFavoritesUseCase
import kotlinx.coroutines.flow.Flow

class GetFavoritesUseCaseImpl(
    private val repository: DatabaseRepository
) : GetFavoritesUseCase {
    override operator fun invoke(): Flow<List<Recipe>> = repository.getFavorites()
}