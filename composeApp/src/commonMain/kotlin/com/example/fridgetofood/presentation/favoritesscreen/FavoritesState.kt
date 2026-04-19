package com.example.fridgetofood.presentation.favoritesscreen

import com.example.fridgetofood.domain.models.Recipe

data class FavoritesState(
    val recipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)