package com.example.fridgetofood.di

import com.example.fridgetofood.data.local.database.DatabaseFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidPlatformModule = module {

    single<DatabaseFactory> {
        DatabaseFactory(androidContext())
    }
}