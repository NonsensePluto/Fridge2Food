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
        if (dao.isFavorite(recipe.id)) {
            dao.removeFromFavorites(recipe.id)
        } else {
            val bundle = recipeDomainToEntity(recipe)
            dao.addToFavorites(
                recipe = bundle.recipe,
                ingredients = bundle.ingredients,
                diets = bundle.diets,
                cuisines = bundle.cuisines,
                ingredientCrossRefs = bundle.ingredientCrossRefs,
                dietCrossRefs = bundle.dietCrossRefs,
                cuisineCrossRefs = bundle.cuisineCrossRefs,
            )
        }
    }

    override fun getFavorites(): Flow<List<Recipe>> {
        return dao.getAllFavorites()
            .map { recipes ->
                recipes.map { favoriteRecipe ->
                    recipeEntityToDomain(favoriteRecipe)
                }
            }
    }

    override suspend fun isFavorite(recipeId: Int): Boolean {
        return dao.isFavorite(recipeId)
    }
}