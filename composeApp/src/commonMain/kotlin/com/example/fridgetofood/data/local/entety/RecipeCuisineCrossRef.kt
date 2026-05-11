package com.example.fridgetofood.data.local.entety

import androidx.room.Entity

@Entity(
    tableName = "recipe_cuisines_cross_ref",
    primaryKeys = ["recipeId", "cuisineName"]
)
data class RecipeCuisineCrossRef(
    val recipeId: Int,
    val cuisineName: String,
)