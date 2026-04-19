package com.example.fridgetofood.data.userpreferences.repository

import com.example.fridgetofood.data.local.dao.RecipeDao
import com.example.fridgetofood.domain.repositories.UserPreferencesRepository
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.serialization.json.Json

class UserPreferencesRepositoryImpl(
    private val dao: RecipeDao
) : UserPreferencesRepository {
    private val json = Json { ignoreUnknownKeys = true }

    override suspend fun getTopDiets(limit: Int): List<Pair<String, Int>> {
        val dietsList = dao.getAllDiets().firstOrNull() ?: return emptyList()
        val allDiets = dietsList.flatMap { json.decodeFromString<List<String>>(it) }
        return allDiets.groupingBy { it }.eachCount()
            .entries.sortedByDescending { it.value }
            .take(limit)
            .map { it.key to it.value }
    }

    override suspend fun getTopCuisines(limit: Int): List<Pair<String, Int>> {
        val cuisinesList = dao.getAllCuisines().firstOrNull() ?: return emptyList()
        val allCuisines = cuisinesList.flatMap { json.decodeFromString<List<String>>(it) }
        return allCuisines.groupingBy { it }.eachCount()
            .entries.sortedByDescending { it.value }
            .take(limit)
            .map { it.key to it.value }
    }
}