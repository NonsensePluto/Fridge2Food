package com.example.fridgetofood.data.local.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fridgetofood.data.local.dao.RecipeDao
import com.example.fridgetofood.data.local.entety.CuisineEntity
import com.example.fridgetofood.data.local.entety.DietEntity
import com.example.fridgetofood.data.local.entety.IngredientEntity
import com.example.fridgetofood.data.local.entety.RecipeCuisineCrossRef
import com.example.fridgetofood.data.local.entety.RecipeDietCrossRef
import com.example.fridgetofood.data.local.entety.RecipeIngredientCrossRef
import com.example.fridgetofood.data.local.entety.SavedRecipeEntity

@Database(
    entities = [
        SavedRecipeEntity::class,
        IngredientEntity::class,
        DietEntity::class,
        CuisineEntity::class,
        RecipeIngredientCrossRef::class,
        RecipeDietCrossRef::class,
        RecipeCuisineCrossRef::class
    ],
    version = 2,
    exportSchema = true
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}