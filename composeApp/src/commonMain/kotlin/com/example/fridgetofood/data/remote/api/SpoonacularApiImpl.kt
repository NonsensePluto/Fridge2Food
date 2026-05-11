package com.example.fridgetofood.data.remote.api

import com.example.fridgetofood.data.remote.dto.RandomRecipesResponse
import com.example.fridgetofood.data.remote.dto.RecipeDto
import com.example.fridgetofood.data.remote.dto.RecipesResponse
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode

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
    ): RandomRecipesResponse {
        Napier.d("SpoonacularApiImpl: getRandomRecipes() — number=$number, diet=$diet, cuisine=$cuisine")
        val response: HttpResponse = client.get("recipes/random") {
            parameter("apiKey", apiKey)
            parameter("number", number)
            diet?.let { parameter("diet", it) }
            intolerances?.let { parameter("intolerances", it) }
            cuisine?.let { parameter("cuisine", it) }
            maxReadyTime?.let { parameter("maxReadyTime", it) }
            includeIngredients?.let { parameter("includeIngredients", it) }
            excludeIngredients?.let { parameter("excludeIngredients", it) }
        }
        Napier.d("SpoonacularApiImpl: getRandomRecipes() — status=${response.status}")
        if (response.status != HttpStatusCode.OK) {
            val bodyText = response.body<String>()
            Napier.e("SpoonacularApiImpl: getRandomRecipes() — ERROR body=$bodyText")
            error("HTTP ${response.status}: $bodyText")
        }
        return response.body()
    }

    override suspend fun findByIngredients(
        ingredients: String,
        number: Int,
        ignorePantry: Boolean
    ): List<RecipeDto> {
        Napier.d("SpoonacularApiImpl: findByIngredients() — ingredients=$ingredients")
        val response: HttpResponse = client.get("recipes/findByIngredients") {
            parameter("apiKey", apiKey)
            parameter("ingredients", ingredients)
            parameter("number", number)
            parameter("ignorePantry", ignorePantry)
        }
        Napier.d("SpoonacularApiImpl: findByIngredients() — status=${response.status}")
        if (response.status != HttpStatusCode.OK) {
            val bodyText = response.body<String>()
            Napier.e("SpoonacularApiImpl: findByIngredients() — ERROR body=$bodyText")
            error("HTTP ${response.status}: $bodyText")
        }
        return response.body()
    }

    override suspend fun complexSearch(
        query: String,
        number: Int,
        diet: String?,
        intolerances: String?,
        cuisine: String?,
        maxReadyTime: Int?,
        addRecipeInformation: Boolean,
    ): RecipesResponse {
        Napier.d("SpoonacularApiImpl: complexSearch() — query=$query, number=$number, addRecipeInformation=$addRecipeInformation")
        val result: HttpResponse = client.get("recipes/complexSearch") {
            parameter("apiKey", apiKey)
            parameter("query", query)
            parameter("number", number)
            parameter("addRecipeInformation", addRecipeInformation)
            parameter("instructionsRequired", false)
            diet?.let { parameter("diet", it) }
            intolerances?.let { parameter("intolerances", it) }
            cuisine?.let { parameter("cuisine", it) }
            maxReadyTime?.let { parameter("maxReadyTime", it) }
        }
        Napier.d("SpoonacularApiImpl: complexSearch() — status=${result.status}")
        if (result.status != HttpStatusCode.OK) {
            val bodyText = result.body<String>()
            Napier.e("SpoonacularApiImpl: complexSearch() — ERROR body=$bodyText")
            error("HTTP ${result.status}: $bodyText")
        }
        return result.body()
    }
}