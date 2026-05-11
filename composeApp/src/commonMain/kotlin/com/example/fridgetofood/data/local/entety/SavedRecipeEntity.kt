package com.example.fridgetofood.data.local.entety

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_recipes")
data class SavedRecipeEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val imageUrl: String,
    val instructions: String,
    val readyInMinutes: Int,
    val usedIngredientCount: Int,
    val missedIngredientCount: Int,
)