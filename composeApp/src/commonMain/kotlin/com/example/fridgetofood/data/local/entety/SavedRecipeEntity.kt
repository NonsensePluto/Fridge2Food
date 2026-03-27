package com.example.fridgetofood.data.local.entety

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "saved_recipes")
data class SavedRecipeEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val imageUrl: String,
    val ingredients: String,
    val instructions: String,
    val readyInMinutes: Int,
    val usedIngredientCount: Int,
    val missedIngredientCount: Int,
)
