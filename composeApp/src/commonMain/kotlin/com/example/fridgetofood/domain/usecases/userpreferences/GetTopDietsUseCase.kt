package com.example.fridgetofood.domain.usecases.userpreferences

interface GetTopDietsUseCase {

    suspend operator fun invoke(limit: Int): List<String>
}