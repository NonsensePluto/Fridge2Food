package com.example.fridgetofood.data.local.entety

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients")
data class IngredientEntity(
    @PrimaryKey
    val id: String,
    val name: String,
)