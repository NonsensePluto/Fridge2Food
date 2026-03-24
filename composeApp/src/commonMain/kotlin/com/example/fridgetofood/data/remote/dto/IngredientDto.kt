package com.example.fridgetofood.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class IngredientDto(
    val id: String,
    val name: String,
    val original: String? = null,
    val amount: Double? = null,
    val unit: String? = null
)
