package com.example.fridgetofood.domain.usecases.local

import com.example.fridgetofood.domain.models.Recipe
import kotlinx.coroutines.flow.Flow

interface GetFavoritesUseCase {
    operator fun invoke(): Flow<List<Recipe>>
}