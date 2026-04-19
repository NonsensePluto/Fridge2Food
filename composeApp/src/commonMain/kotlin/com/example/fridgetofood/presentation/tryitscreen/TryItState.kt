package com.example.fridgetofood.presentation.tryitscreen

import com.example.fridgetofood.domain.models.Recipe

data class TryItState(
    val recipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)