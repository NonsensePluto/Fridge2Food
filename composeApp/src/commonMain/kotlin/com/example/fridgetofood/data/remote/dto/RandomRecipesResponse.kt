package com.example.fridgetofood.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RandomRecipesResponse(
    val recipes: List<RecipeDto>
)
