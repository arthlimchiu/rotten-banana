package com.arthlimchiu.rottenbanana.core.data.di

import com.arthlimchiu.rottenbanana.core.data.movies.MoviesRepository
import com.arthlimchiu.rottenbanana.core.data.movies.MoviesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsMoviesRepository(repository: MoviesRepositoryImpl): MoviesRepository
}