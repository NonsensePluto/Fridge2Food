package com.example.fridgetofood.domain.usecases.userpreferences

interface GetTopCuisinesUseCase {

    suspend operator fun invoke(limit: Int): List<String>
}