package com.example.fridgetofood.domain.usecase.userpreferences

interface GetTopDietsUseCase {

    suspend operator fun invoke(limit: Int): List<String>
}