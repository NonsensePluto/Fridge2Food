package com.example.fridgetofood.domain.usecase.local.impl

import com.example.fridgetofood.domain.model.Recipe
import com.example.fridgetofood.domain.repository.DatabaseRepository
import com.example.fridgetofood.domain.usecase.local.FindFavoriteRecipeByIdUseCase
import kotlinx.coroutines.flow.Flow

class FindFavoriteRecipeByIdUseCaseImpl(
    private val repository: DatabaseRepository
) : FindFavoriteRecipeByIdUseCase {
    override operator fun invoke(recipeId: Int): Flow<Recipe?> = repository.findFavoriteRecipeById(recipeId)
}