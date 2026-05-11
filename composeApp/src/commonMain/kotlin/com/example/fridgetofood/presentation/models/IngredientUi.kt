package com.example.fridgetofood.presentation.models

data class IngredientUi(
    val id: String,
    val name: String,
    val original: String? = null,
    val amount: Double? = null,
    val unit: String? = null
)
