package com.example.fridgetofood.data.local.entety

import androidx.room.Entity

@Entity(
    tableName = "recipe_ingredients_cross_ref",
    primaryKeys = ["recipeId", "ingredientId"]
)
data class RecipeIngredientCrossRef(
    val recipeId: Int,
    val ingredientId: String,
)