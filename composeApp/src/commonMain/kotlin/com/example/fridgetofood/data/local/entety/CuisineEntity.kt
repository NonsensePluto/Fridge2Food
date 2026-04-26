package com.example.fridgetofood.data.local.entety

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cuisines")
data class CuisineEntity(
    @PrimaryKey
    val name: String,
)