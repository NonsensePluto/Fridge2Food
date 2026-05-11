package com.example.fridgetofood.presentation.ui.searchscreen

import com.example.fridgetofood.presentation.models.RecipeUi

data class SearchState(
    val query: String? = null,
    val recipes: List<RecipeUi> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)
