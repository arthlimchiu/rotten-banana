package com.arthlimchiu.rottenbanana.core.database

import com.arthlimchiu.rottenbanana.core.database.dao.MoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun providesMoviesDao(database: AppDatabase): MoviesDao = database.moviesDao()
}