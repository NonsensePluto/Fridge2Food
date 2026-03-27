package com.example.fridgetofood.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDto(
    val id: Int,
    val title: String,
    @SerialName("image")
    val imageUrl: String?,
    @SerialName("usedIngredientCount")
    val usedIngredientCount: Int? = null,
    @SerialName("missedIngredientCount")
    val missedIngredientCount: Int? = null,
    val missedIngredients: List<IngredientDto>? = null,
    val usedIngredients: List<IngredientDto>? = null,
    val extendedIngredients: List<IngredientDto>? = null,
    val instructions: String? = null,
    @SerialName("readyInMinutes")
    val readyInMinutes: Int? = null,
    val diets: List<String>? = null,
    val cuisines: List<String>? = null,
)