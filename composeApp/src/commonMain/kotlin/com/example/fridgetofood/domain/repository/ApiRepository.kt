package com.example.fridgetofood.domain.repository

import com.example.fridgetofood.domain.model.Recipe

interface ApiRepository {

    suspend fun getRandomRecipes(
        limit: Int,
        diet: String?,
        intolerances: String?,
        cuisines: String?,
        maxReadyTime: Int?,
        includeIngredients: String?,
        excludeIngredients: String?
    ): List<Recipe>

    suspend fun searchByIngredients(
        ingredients: String,
        number: Int,
        ignorePantry: Boolean
    ): List<Recipe>

    suspend fun searchByQuery(
        query: String,
        number: Int,
        diet: String?,
        intolerances: String?,
        cuisine: String?,
        maxReadyTime: Int?
    ): List<Recipe>
}