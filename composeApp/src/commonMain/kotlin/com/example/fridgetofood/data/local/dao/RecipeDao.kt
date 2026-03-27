package com.example.fridgetofood.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fridgetofood.data.local.entety.SavedRecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addToFavorites(recipe: SavedRecipeEntity)

    @Delete
    suspend fun removeFromFavorites(recipe: SavedRecipeEntity)

    @Query("SELECT * FROM saved_recipes")
    fun getAllFavorites(): Flow<List<SavedRecipeEntity>>

    @Query("SELECT EXISTS (SELECT * FROM saved_recipes WHERE id = :recipeId)")
    suspend fun isFavorite(recipeId: Int): Boolean

    @Query("SELECT * FROM saved_recipes WHERE id = :recipeId")
    fun findById(recipeId: Int): Flow<SavedRecipeEntity?>
}