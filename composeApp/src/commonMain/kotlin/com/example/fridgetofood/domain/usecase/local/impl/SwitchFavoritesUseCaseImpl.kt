package com.example.fridgetofood.domain.usecase.local.impl

import com.example.fridgetofood.domain.model.Recipe
import com.example.fridgetofood.domain.repository.DatabaseRepository
import com.example.fridgetofood.domain.usecase.local.SwitchFavoritesUseCase

class SwitchFavoritesUseCaseImpl(
    private val repository: DatabaseRepository
) : SwitchFavoritesUseCase {
    override suspend operator fun invoke(recipe: Recipe) {
        repository.switchFavorites(recipe)
    }
}