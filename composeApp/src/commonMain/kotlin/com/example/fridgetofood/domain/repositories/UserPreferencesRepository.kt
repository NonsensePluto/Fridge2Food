package com.example.fridgetofood.domain.repositories


interface UserPreferencesRepository {

    suspend fun getTopDiets(limit: Int = 3): List<Pair<String, Int>>

    suspend fun getTopCuisines(limit: Int = 3): List<Pair<String, Int>>
}