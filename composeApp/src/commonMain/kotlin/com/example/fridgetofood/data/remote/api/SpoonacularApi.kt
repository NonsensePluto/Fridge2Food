package com.example.fridgetofood.data.remote.api

import com.example.fridgetofood.data.remote.dto.RandomRecipesResponse
import com.example.fridgetofood.data.remote.dto.RecipeDto
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
    ): RandomRecipesResponse

    suspend fun findByIngredients(
        ingredients: String,
        number: Int = 10,
        ignorePantry: Boolean = true
    ): List<RecipeDto>

    suspend fun complexSearch(
        query: String,
        number: Int = 10,
        diet: String? = null,
        intolerances: String? = null,
        cuisine: String? = null,
        maxReadyTime: Int? = null,
        addRecipeInformation: Boolean = true,
    ): RecipesResponse
}