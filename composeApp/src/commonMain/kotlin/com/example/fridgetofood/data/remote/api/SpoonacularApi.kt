package com.example.fridgetofood.data.remote.api

import com.example.fridgetofood.data.remote.dto.RecipesResponse

interface SpoonacularApi {

    suspend fun getRandomRecipes(
        number: Int = 10,
        diet: String? = null,
        intolerances: String? = null,
        cuisine: String? = null,
        maxReadyTime: Int? = null,
        includeIngredients: String? = null,
        excludeIngredients: String? = null,
    ): RecipesResponse

    suspend fun findByIngredients(
        ingredients: String,
        number: Int = 10,
        ignorePantry: Boolean = true
    ): RecipesResponse

    suspend fun complexSearch(
        query: String,
        number: Int = 10,
        diet: String? = null,
        intolerances: String? = null,
        cuisine: String? = null,
        maxReadyTime: Int? = null
    ): RecipesResponse
}