package com.example.fridgetofood.di

import com.example.fridgetofood.data.repository.ApiRepositoryImpl
import com.example.fridgetofood.domain.repository.ApiRepository
import com.example.fridgetofood.domain.usecase.GetRandomRecipesUseCase
import com.example.fridgetofood.domain.usecase.SearchByIngredientsUseCase
import com.example.fridgetofood.domain.usecase.SearchByQueryUseCase
import com.example.fridgetofood.domain.usecase.impl.GetRandomRecipesUseCaseImpl
import com.example.fridgetofood.domain.usecase.impl.SearchByIngredientsUseCaseImpl
import com.example.fridgetofood.domain.usecase.impl.SearchByQueryUseCaseImpl
import org.koin.dsl.module

val domainModule = module {

    single<ApiRepository> {
        ApiRepositoryImpl(get(), get())
    }

    single<GetRandomRecipesUseCase> { GetRandomRecipesUseCaseImpl(get()) }

    single<SearchByIngredientsUseCase> { SearchByIngredientsUseCaseImpl(get()) }

    single<SearchByQueryUseCase> { SearchByQueryUseCaseImpl(get()) }
}