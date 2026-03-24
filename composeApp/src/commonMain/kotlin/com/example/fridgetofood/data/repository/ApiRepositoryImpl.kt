package com.example.fridgetofood.data.repository

import com.example.fridgetofood.data.remote.api.SpoonacularApi
import com.example.fridgetofood.data.remote.mappers.RecipeDtoToDomainMapper
import com.example.fridgetofood.domain.model.Recipe
import com.example.fridgetofood.domain.repository.ApiRepository

class ApiRepositoryImpl(
    private val api: SpoonacularApi,
    private val recipeMapper: RecipeDtoToDomainMapper,
) : ApiRepository {

    override suspend fun getRandomRecipes(
        limit: Int,
        diet: String?,
        intolerances: String?,
        cuisines: String?,
        maxReadyTime: Int?,
        includeIngredients: String?,
        excludeIngredients: String?
    ): List<Recipe> {
        return api.getRandomRecipes().recipes.map {
            recipeMapper(it)
        }
    }

    override suspend fun searchByIngredients(
        ingredients: String,
        number: Int,
        ignorePantry: Boolean
    ): List<Recipe> {
        return api.findByIngredients(ingredients).recipes.map {
            recipeMapper(it)
        }
    }

    override suspend fun searchByQuery(
        query: String,
        number: Int,
        diet: String?,
        intolerances: String?,
        cuisine: String?,
        maxReadyTime: Int?
    ): List<Recipe> {
        return api.complexSearch(query).recipes.map {
            recipeMapper(it)
        }
    }

}