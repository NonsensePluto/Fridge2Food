package com.example.fridgetofood.domain.models

data class Ingredient(
    val id: String,
    val name: String,
    val original: String? = null,
    val amount: Double? = null,
    val unit: String? = null
)
