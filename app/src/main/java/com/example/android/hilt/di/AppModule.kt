package com.example.android.hilt.di

import android.app.Application
import androidx.room.Room
import com.example.android.hilt.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton


@InstallIn(Singleton::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun getDatabase(application: Application) = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "logging.db"
    ).build()
    @Provides
    fun getDao(database: AppDatabase) = database.logDao()
}