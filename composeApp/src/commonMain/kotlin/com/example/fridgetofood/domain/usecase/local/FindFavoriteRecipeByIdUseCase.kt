package com.example.fridgetofood.domain.usecase.local

import com.example.fridgetofood.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface FindFavoriteRecipeByIdUseCase {
    operator fun invoke(recipeId: Int): Flow<Recipe?>
}