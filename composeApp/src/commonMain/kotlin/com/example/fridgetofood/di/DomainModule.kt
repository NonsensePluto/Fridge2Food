package com.example.fridgetofood.di

import com.example.fridgetofood.data.remote.repository.ApiRepositoryImpl
import com.example.fridgetofood.data.local.repository.DatabaseRepositoryImpl
import com.example.fridgetofood.data.userpreferences.repository.UserPreferencesRepositoryImpl
import com.example.fridgetofood.domain.repositories.ApiRepository
import com.example.fridgetofood.domain.repositories.DatabaseRepository
import com.example.fridgetofood.domain.repositories.UserPreferencesRepository
import com.example.fridgetofood.domain.usecases.local.GetFavoritesUseCase
import com.example.fridgetofood.domain.usecases.local.IsFavoriteUseCase
import com.example.fridgetofood.domain.usecases.local.SwitchFavoritesUseCase
import com.example.fridgetofood.domain.usecases.local.impl.GetFavoritesUseCaseImpl
import com.example.fridgetofood.domain.usecases.local.impl.IsFavoriteUseCaseImpl
import com.example.fridgetofood.domain.usecases.local.impl.SwitchFavoritesUseCaseImpl
import com.example.fridgetofood.domain.usecases.remote.GetRandomRecipesUseCase
import com.example.fridgetofood.domain.usecases.remote.SearchByIngredientsUseCase
import com.example.fridgetofood.domain.usecases.remote.SearchByQueryUseCase
import com.example.fridgetofood.domain.usecases.remote.impl.GetRandomRecipesUseCaseImpl
import com.example.fridgetofood.domain.usecases.remote.impl.SearchByIngredientsUseCaseImpl
import com.example.fridgetofood.domain.usecases.remote.impl.SearchByQueryUseCaseImpl
import com.example.fridgetofood.domain.usecases.userpreferences.GetTopCuisinesUseCase
import com.example.fridgetofood.domain.usecases.userpreferences.GetTopDietsUseCase
import com.example.fridgetofood.domain.usecases.userpreferences.impl.GetTopCuisinesUseCaseImpl
import com.example.fridgetofood.domain.usecases.userpreferences.impl.GetTopDietsUseCaseImpl
import org.koin.dsl.module

val domainModule = module {

    // Remote
    single<ApiRepository> {
        ApiRepositoryImpl(get(), get())
    }

    single<GetRandomRecipesUseCase> { GetRandomRecipesUseCaseImpl(get()) }

    single<SearchByIngredientsUseCase> { SearchByIngredientsUseCaseImpl(get()) }

    single<SearchByQueryUseCase> { SearchByQueryUseCaseImpl(get()) }

    // Local
    single<DatabaseRepository> {
        DatabaseRepositoryImpl(get(), get(), get())
    }

    single<GetFavoritesUseCase> { GetFavoritesUseCaseImpl(get()) }

    single<IsFavoriteUseCase> { IsFavoriteUseCaseImpl(get()) }

    single<SwitchFavoritesUseCase> { SwitchFavoritesUseCaseImpl(get()) }

    // Userprefs
    single<UserPreferencesRepository> {
        UserPreferencesRepositoryImpl(get())
    }

    single<GetTopDietsUseCase> { GetTopDietsUseCaseImpl(get()) }

    single<GetTopCuisinesUseCase> { GetTopCuisinesUseCaseImpl(get()) }
}