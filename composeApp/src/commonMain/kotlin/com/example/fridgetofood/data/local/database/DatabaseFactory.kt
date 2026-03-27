package com.example.fridgetofood.data.local.database

expect class DatabaseFactory {

    fun createAppDatabase(): AppDatabase
}