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
    suspend fun addToFavorites(book: SavedRecipeEntity)

    @Delete
    suspend fun removeFromFavorites(book: SavedRecipeEntity)

    @Query("SELECT * FROM saved_recipes")
    fun getAllFavorites(): Flow<List<SavedRecipeEntity>>

    @Query("SELECT EXISTS (SELECT * FROM saved_recipes WHERE id = :bookId)")
    fun isFavorite(bookId: String): Flow<Boolean>

    @Query("SELECT * FROM saved_recipes WHERE id = :bookId")
    fun findById(bookId: String): Flow<SavedRecipeEntity?>
}