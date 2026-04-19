package com.example.fridgetofood.data.local.repository

import com.example.fridgetofood.data.local.dao.RecipeDao
import com.example.fridgetofood.data.local.mappers.RecipeDomainToEntity
import com.example.fridgetofood.data.local.mappers.RecipeEntityToDomain
import com.example.fridgetofood.domain.models.Recipe
import com.example.fridgetofood.domain.repositories.DatabaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DatabaseRepositoryImpl(
    private val dao: RecipeDao,
    private val recipeEntityToDomain: RecipeEntityToDomain,
    private val recipeDomainToEntity: RecipeDomainToEntity
): DatabaseRepository {
    override suspend fun switchFavorites(recipe: Recipe) {
        val mappedRecipe = recipeDomainToEntity(recipe)
        if (dao.isFavorite(recipe.id)) {
            dao.removeFromFavorites(mappedRecipe)
        } else {
            dao.addToFavorites(mappedRecipe)
        }
    }

    override fun getFavorites(): Flow<List<Recipe>> {
        return dao.getAllFavorites()
            .map { recipe ->
                recipe.map { favoriteRecipe->
                    recipeEntityToDomain(favoriteRecipe)
                }
            }
    }

    override suspend fun isFavorite(recipeId: Int): Boolean {
        return dao.isFavorite(recipeId)
    }
}