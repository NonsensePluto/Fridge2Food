package com.example.fridgetofood.domain.usecases.local.impl

import com.example.fridgetofood.domain.models.Recipe
import com.example.fridgetofood.domain.repositories.DatabaseRepository
import com.example.fridgetofood.domain.usecases.local.SwitchFavoritesUseCase

class SwitchFavoritesUseCaseImpl(
    private val repository: DatabaseRepository
) : SwitchFavoritesUseCase {
    override suspend operator fun invoke(recipe: Recipe) {
        repository.switchFavorites(recipe)
    }
}