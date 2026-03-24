package com.example.fridgetofood.di

import com.example.fridgetofood.data.remote.api.SpoonacularApi
import com.example.fridgetofood.data.remote.createHttpClient
import org.koin.dsl.module
import com.example.fridgetofood.data.remote.api.SpoonacularApiImpl
import com.example.fridgetofood.data.remote.mappers.IngredientDtoToDomainMapper
import com.example.fridgetofood.data.remote.mappers.RecipeDtoToDomainMapper
import com.example.fridgetofood.data.repository.ApiRepositoryImpl
import com.example.fridgetofood.domain.repository.ApiRepository

val dataModule = module {
    single { createHttpClient() }

    single<SpoonacularApi> {
        SpoonacularApiImpl(get(), "2f92401f462b4cb2b5a7474beaadd65d")
    }

    single {
        IngredientDtoToDomainMapper()
    }

    single {
        RecipeDtoToDomainMapper(get())
    }

    single<ApiRepository> {
        ApiRepositoryImpl(get(), get())
    }
}