package com.example.fridgetofood.domain.usecase.local

interface IsFavoriteUseCase {
    suspend operator fun invoke(recipeId: Int): Boolean
}