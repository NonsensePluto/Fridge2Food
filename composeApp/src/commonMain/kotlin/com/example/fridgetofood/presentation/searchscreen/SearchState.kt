package com.example.fridgetofood.presentation.searchscreen

import com.example.fridgetofood.domain.models.Recipe

data class SearchState(
    val query: String? = null,//TODO подумать над тем чтобы убрать
    val recipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)