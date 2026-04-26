package com.example.fridgetofood.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.fridgetofood.data.local.entety.CuisineEntity
import com.example.fridgetofood.data.local.entety.DietEntity
import com.example.fridgetofood.data.local.entety.IngredientEntity
import com.example.fridgetofood.data.local.entety.RecipeCuisineCrossRef
import com.example.fridgetofood.data.local.entety.RecipeDietCrossRef
import com.example.fridgetofood.data.local.entety.RecipeIngredientCrossRef
import com.example.fridgetofood.data.local.entety.SavedRecipeEntity
import com.example.fridgetofood.data.local.entety.SavedRecipeWithRelations
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: SavedRecipeEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertIngredients(ingredients: List<IngredientEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDiets(diets: List<DietEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCuisines(cuisines: List<CuisineEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipeIngredientCrossRefs(crossRefs: List<RecipeIngredientCrossRef>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipeDietCrossRefs(crossRefs: List<RecipeDietCrossRef>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipeCuisineCrossRefs(crossRefs: List<RecipeCuisineCrossRef>)

    @Query("DELETE FROM recipe_ingredients_cross_ref WHERE recipeId = :recipeId")
    suspend fun deleteRecipeIngredientCrossRefs(recipeId: Int)

    @Query("DELETE FROM recipe_diets_cross_ref WHERE recipeId = :recipeId")
    suspend fun deleteRecipeDietCrossRefs(recipeId: Int)

    @Query("DELETE FROM recipe_cuisines_cross_ref WHERE recipeId = :recipeId")
    suspend fun deleteRecipeCuisineCrossRefs(recipeId: Int)

    @Query("DELETE FROM saved_recipes WHERE id = :recipeId")
    suspend fun deleteRecipeById(recipeId: Int)

    @Transaction
    suspend fun addToFavorites(
        recipe: SavedRecipeEntity,
        ingredients: List<IngredientEntity>,
        diets: List<DietEntity>,
        cuisines: List<CuisineEntity>,
        ingredientCrossRefs: List<RecipeIngredientCrossRef>,
        dietCrossRefs: List<RecipeDietCrossRef>,
        cuisineCrossRefs: List<RecipeCuisineCrossRef>,
    ) {
        insertRecipe(recipe)
        if (ingredients.isNotEmpty()) insertIngredients(ingredients)
        if (diets.isNotEmpty()) insertDiets(diets)
        if (cuisines.isNotEmpty()) insertCuisines(cuisines)
        if (ingredientCrossRefs.isNotEmpty()) insertRecipeIngredientCrossRefs(ingredientCrossRefs)
        if (dietCrossRefs.isNotEmpty()) insertRecipeDietCrossRefs(dietCrossRefs)
        if (cuisineCrossRefs.isNotEmpty()) insertRecipeCuisineCrossRefs(cuisineCrossRefs)
    }

    @Transaction
    suspend fun removeFromFavorites(recipeId: Int) {
        deleteRecipeIngredientCrossRefs(recipeId)
        deleteRecipeDietCrossRefs(recipeId)
        deleteRecipeCuisineCrossRefs(recipeId)
        deleteRecipeById(recipeId)
    }

    @Transaction
    @Query("SELECT * FROM saved_recipes")
    fun getAllFavorites(): Flow<List<SavedRecipeWithRelations>>

    @Query("SELECT EXISTS (SELECT * FROM saved_recipes WHERE id = :recipeId)")
    suspend fun isFavorite(recipeId: Int): Boolean

    @Query("SELECT name FROM diets")
    fun getAllDiets(): Flow<List<String>>

    @Query("SELECT name FROM cuisines")
    fun getAllCuisines(): Flow<List<String>>
}