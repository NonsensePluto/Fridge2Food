package com.example.fridgetofood.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipesResponse(
    @SerialName("results")
    val recipes: List<RecipeDto>
)
