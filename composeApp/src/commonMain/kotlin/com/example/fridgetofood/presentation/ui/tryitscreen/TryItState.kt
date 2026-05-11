package com.example.fridgetofood.presentation.ui.tryitscreen

import com.example.fridgetofood.presentation.models.RecipeUi

data class TryItState(
    val recipes: List<RecipeUi> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)
