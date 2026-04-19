package com.example.fridgetofood.domain.usecases.local

import com.example.fridgetofood.domain.models.Recipe

interface SwitchFavoritesUseCase {
    suspend operator fun invoke(recipe: Recipe)
}