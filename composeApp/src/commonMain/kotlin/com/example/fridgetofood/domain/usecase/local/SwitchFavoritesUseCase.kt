package com.example.fridgetofood.domain.usecase.local

import com.example.fridgetofood.domain.model.Recipe

interface SwitchFavoritesUseCase {
    suspend operator fun invoke(recipe: Recipe)
}