package com.example.fridgetofood.data.local.entety

import androidx.room.Entity

@Entity(
    tableName = "recipe_diets_cross_ref",
    primaryKeys = ["recipeId", "dietName"]
)
data class RecipeDietCrossRef(
    val recipeId: Int,
    val dietName: String,
)