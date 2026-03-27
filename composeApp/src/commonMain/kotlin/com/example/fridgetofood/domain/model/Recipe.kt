package com.example.fridgetofood.domain.model

data class Recipe(
    val id: Int,
    val title: String,
    val imageUrl: String?,
    val usedIngredientCount: Int? = null,
    val missedIngredientCount: Int? = null,
    val ingredients: List<Ingredient>? = null,
    val instructions: String? = null,
    val readyInMinutes: Int? = null
)
