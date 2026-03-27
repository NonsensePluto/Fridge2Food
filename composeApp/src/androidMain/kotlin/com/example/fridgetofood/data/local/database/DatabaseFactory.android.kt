package com.example.fridgetofood.data.local.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.example.fridgetofood.data.local.database.utils.DATABASE_NAME
import kotlinx.coroutines.Dispatchers

actual class DatabaseFactory(
    private val context: Context
) {
    actual fun createAppDatabase(): AppDatabase {
        val dbFilePath = context.getDatabasePath(DATABASE_NAME)
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            dbFilePath.absolutePath
        )
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}