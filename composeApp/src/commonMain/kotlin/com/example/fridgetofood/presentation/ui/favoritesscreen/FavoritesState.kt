package com.example.fridgetofood.presentation.ui.favoritesscreen

import com.example.fridgetofood.presentation.models.RecipeUi

data class FavoritesState(
    val recipes: List<RecipeUi> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)
