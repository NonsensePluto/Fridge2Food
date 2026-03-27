package com.example.fridgetofood.domain.usecase.local

import com.example.fridgetofood.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface GetFavoritesUseCase {
    operator fun invoke(): Flow<List<Recipe>>
}