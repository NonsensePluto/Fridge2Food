package com.example.fridgetofood.data.remote.api

import com.example.fridgetofood.data.remote.dto.RecipesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class SpoonacularApiImpl(
    private val client: HttpClient,
    private val apiKey: String
) : SpoonacularApi {

    override suspend fun getRandomRecipes(
        number: Int,
        diet: String?,
        intolerances: String?,
        cuisine: String?,
        maxReadyTime: Int?,
        includeIngredients: String?,
        excludeIngredients: String?
    ): RecipesResponse {
        return client.get("recipes/random") {
            parameter("apiKey", apiKey)
            parameter("number", number)
            diet?.let { parameter("diet", it) }
            intolerances?.let { parameter("intolerances", it) }
            cuisine?.let { parameter("cuisine", it) }
            maxReadyTime?.let { parameter("maxReadyTime", it) }
            includeIngredients?.let { parameter("includeIngredients", it) }
            excludeIngredients?.let { parameter("excludeIngredients", it) }
        }.body()
    }

    override suspend fun findByIngredients(
        ingredients: String,
        number: Int,
        ignorePantry: Boolean
    ): RecipesResponse {
        return client.get("recipes/findByIngredients") {
            parameter("apiKey", apiKey)
            parameter("ingredients", ingredients)
            parameter("number", number)
            parameter("ignorePantry", ignorePantry)
        }.body()
    }

    override suspend fun complexSearch(
        query: String,
        number: Int,
        diet: String?,
        intolerances: String?,
        cuisine: String?,
        maxReadyTime: Int?
    ): RecipesResponse {
        val result =  client.get("recipes/complexSearch") {
            parameter("apiKey", apiKey)
            parameter("query", query)
            parameter("number", number)
            diet?.let { parameter("diet", it) }
            intolerances?.let { parameter("intolerances", it) }
            cuisine?.let { parameter("cuisine", it) }
            maxReadyTime?.let { parameter("maxReadyTime", it) }
        }

        return result.body()
    }
}