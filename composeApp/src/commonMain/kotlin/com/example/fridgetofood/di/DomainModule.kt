package com.example.fridgetofood.di

import com.example.fridgetofood.data.repository.ApiRepositoryImpl
import com.example.fridgetofood.data.repository.DatabaseRepositoryImpl
import com.example.fridgetofood.data.repository.UserPreferencesRepositoryImpl
import com.example.fridgetofood.domain.repository.ApiRepository
import com.example.fridgetofood.domain.repository.DatabaseRepository
import com.example.fridgetofood.domain.repository.UserPreferencesRepository
import com.example.fridgetofood.domain.usecase.local.FindFavoriteRecipeByIdUseCase
import com.example.fridgetofood.domain.usecase.local.GetFavoritesUseCase
import com.example.fridgetofood.domain.usecase.local.IsFavoriteUseCase
import com.example.fridgetofood.domain.usecase.local.SwitchFavoritesUseCase
import com.example.fridgetofood.domain.usecase.local.impl.FindFavoriteRecipeByIdUseCaseImpl
import com.example.fridgetofood.domain.usecase.local.impl.GetFavoritesUseCaseImpl
import com.example.fridgetofood.domain.usecase.local.impl.IsFavoriteUseCaseImpl
import com.example.fridgetofood.domain.usecase.local.impl.SwitchFavoritesUseCaseImpl
import com.example.fridgetofood.domain.usecase.remote.GetRandomRecipesUseCase
import com.example.fridgetofood.domain.usecase.remote.SearchByIngredientsUseCase
import com.example.fridgetofood.domain.usecase.remote.SearchByQueryUseCase
import com.example.fridgetofood.domain.usecase.remote.impl.GetRandomRecipesUseCaseImpl
import com.example.fridgetofood.domain.usecase.remote.impl.SearchByIngredientsUseCaseImpl
import com.example.fridgetofood.domain.usecase.remote.impl.SearchByQueryUseCaseImpl
import com.example.fridgetofood.domain.usecase.userpreferences.GetTopCuisinesUseCase
import com.example.fridgetofood.domain.usecase.userpreferences.GetTopDietsUseCase
import com.example.fridgetofood.domain.usecase.userpreferences.impl.GetTopCuisinesUseCaseImpl
import com.example.fridgetofood.domain.usecase.userpreferences.impl.GetTopDietsUseCaseImpl
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

    single<FindFavoriteRecipeByIdUseCase> { FindFavoriteRecipeByIdUseCaseImpl(get()) }

    single<GetFavoritesUseCase> { GetFavoritesUseCaseImpl(get()) }

    single<IsFavoriteUseCase> { IsFavoriteUseCaseImpl(get()) }

    single<SwitchFavoritesUseCase> { SwitchFavoritesUseCaseImpl(get()) }

    // userprefs
    single<UserPreferencesRepository> { UserPreferencesRepositoryImpl(get()) }

    single<GetTopDietsUseCase> { GetTopDietsUseCaseImpl(get()) }

    single<GetTopCuisinesUseCase> { GetTopCuisinesUseCaseImpl(get()) }
}