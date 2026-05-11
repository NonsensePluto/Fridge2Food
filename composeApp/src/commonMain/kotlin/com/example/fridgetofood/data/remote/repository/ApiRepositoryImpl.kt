package com.example.fridgetofood.data.remote.repository

import com.example.fridgetofood.data.remote.api.SpoonacularApi
import com.example.fridgetofood.data.remote.mappers.RecipeDtoToDomainMapper
import com.example.fridgetofood.domain.models.Recipe
import com.example.fridgetofood.domain.repositories.ApiRepository
import io.github.aakira.napier.Napier

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
        Napier.d("ApiRepositoryImpl: getRandomRecipes() called — limit=$limit, diet=$diet, cuisines=$cuisines")
        return try {
            val response = api.getRandomRecipes(
                number = limit,
                diet = diet,
                intolerances = intolerances,
                cuisine = cuisines,
                maxReadyTime = maxReadyTime,
                includeIngredients = includeIngredients,
                excludeIngredients = excludeIngredients,
            )
            Napier.d("ApiRepositoryImpl: getRandomRecipes() received ${response.recipes.size} recipes")
            response.recipes.map { recipeMapper(it) }
        } catch (e: Exception) {
            Napier.e("ApiRepositoryImpl: getRandomRecipes() failed", e)
            throw e
        }
    }

    override suspend fun searchByIngredients(
        ingredients: String,
        number: Int,
        ignorePantry: Boolean
    ): List<Recipe> {
        Napier.d("ApiRepositoryImpl: searchByIngredients() called — ingredients=$ingredients, number=$number")
        return try {
            val response = api.findByIngredients(
                ingredients = ingredients,
                number = number,
                ignorePantry = ignorePantry,
            )
            Napier.d("ApiRepositoryImpl: searchByIngredients() received ${response.size} recipes")
            response.map { recipeMapper(it) }
        } catch (e: Exception) {
            Napier.e("ApiRepositoryImpl: searchByIngredients() failed", e)
            throw e
        }
    }

    override suspend fun searchByQuery(
        query: String,
        number: Int,
        diet: String?,
        intolerances: String?,
        cuisine: String?,
        maxReadyTime: Int?,
        addRecipeInformation: Boolean,
    ): List<Recipe> {
        Napier.d("ApiRepositoryImpl: searchByQuery() called — query=$query, number=$number, addRecipeInformation=$addRecipeInformation")
        return try {
            val response = api.complexSearch(
                query = query,
                number = number,
                diet = diet,
                intolerances = intolerances,
                cuisine = cuisine,
                maxReadyTime = maxReadyTime,
                addRecipeInformation = addRecipeInformation,
            )
            Napier.d("ApiRepositoryImpl: searchByQuery() received ${response.recipes.size} recipes")
            response.recipes.map { recipeMapper(it) }
        } catch (e: Exception) {
            Napier.e("ApiRepositoryImpl: searchByQuery() failed", e)
            throw e
        }
    }

}