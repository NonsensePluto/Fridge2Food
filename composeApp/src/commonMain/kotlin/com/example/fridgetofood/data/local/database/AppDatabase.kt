package com.example.fridgetofood.data.local.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fridgetofood.data.local.dao.RecipeDao
import com.example.fridgetofood.data.local.entety.SavedRecipeEntity

@Database(
    entities = [SavedRecipeEntity::class],
    version = 1,
    exportSchema = true
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}