package com.example.fridgetofood.di

import com.example.fridgetofood.data.repository.ApiRepositoryImpl
import com.example.fridgetofood.domain.repository.ApiRepository
import com.example.fridgetofood.domain.usecase.remote.GetRandomRecipesUseCase
import com.example.fridgetofood.domain.usecase.remote.SearchByIngredientsUseCase
import com.example.fridgetofood.domain.usecase.remote.SearchByQueryUseCase
import com.example.fridgetofood.domain.usecase.remote.impl.GetRandomRecipesUseCaseImpl
import com.example.fridgetofood.domain.usecase.remote.impl.SearchByIngredientsUseCaseImpl
import com.example.fridgetofood.domain.usecase.remote.impl.SearchByQueryUseCaseImpl
import org.koin.dsl.module

val domainModule = module {

    single<ApiRepository> {
        ApiRepositoryImpl(get(), get())
    }

    single<GetRandomRecipesUseCase> { GetRandomRecipesUseCaseImpl(get()) }

    single<SearchByIngredientsUseCase> { SearchByIngredientsUseCaseImpl(get()) }

    single<SearchByQueryUseCase> { SearchByQueryUseCaseImpl(get()) }
}