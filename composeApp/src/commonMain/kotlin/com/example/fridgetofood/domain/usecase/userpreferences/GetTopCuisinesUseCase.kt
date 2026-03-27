package com.example.fridgetofood.domain.usecase.userpreferences

interface GetTopCuisinesUseCase {

    suspend operator fun invoke(limit: Int): List<String>
}