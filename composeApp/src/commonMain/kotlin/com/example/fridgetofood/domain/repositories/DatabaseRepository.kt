package com.example.fridgetofood.domain.repositories

import com.example.fridgetofood.domain.models.Recipe
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {
    suspend fun switchFavorites(recipe: Recipe)
    fun getFavorites(): Flow<List<Recipe>>
    suspend fun isFavorite(recipeId: Int): Boolean
}