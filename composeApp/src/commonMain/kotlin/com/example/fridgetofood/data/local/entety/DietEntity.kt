package com.example.fridgetofood.data.local.entety

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diets")
data class DietEntity(
    @PrimaryKey
    val name: String,
)