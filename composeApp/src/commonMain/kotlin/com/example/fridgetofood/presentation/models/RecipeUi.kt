package com.example.fridgetofood.presentation.models

data class RecipeUi(
    val id: Int,
    val title: String,
    val imageUrl: String?,
    val usedIngredientCount: Int? = null,
    val missedIngredientCount: Int? = null,
    val ingredients: List<IngredientUi>? = null,
    val summary: String? = null,
    val instructions: String? = null,
    val readyInMinutes: Int? = null,
    val diets: List<String>? = null,
    val cuisines: List<String>? = null,
    val isFavorite: Boolean = false,
)
