package com.example.fridgetofood.domain.repository

import com.example.fridgetofood.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {
    suspend fun switchFavorites(recipe: Recipe)
    fun getFavorites(): Flow<List<Recipe>>
    fun findFavoriteRecipeById(recipeId: Int): Flow<Recipe?>
    suspend fun isFavorite(recipeId: Int): Boolean
}