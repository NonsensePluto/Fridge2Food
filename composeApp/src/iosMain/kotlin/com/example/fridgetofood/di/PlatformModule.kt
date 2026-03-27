package com.example.fridgetofood.di

import com.example.fridgetofood.data.local.database.DatabaseFactory
import org.koin.dsl.module

val iosPlatformModule = module {

    single<DatabaseFactory> { DatabaseFactory() }
}