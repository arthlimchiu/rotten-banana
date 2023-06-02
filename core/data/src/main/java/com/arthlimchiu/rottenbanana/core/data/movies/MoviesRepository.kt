package com.arthlimchiu.rottenbanana.core.data.movies

import com.arthlimchiu.rottenbanana.core.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    fun observeNowPlayingMovies(): Flow<List<Movie>>

    fun observePopularMovies(): Flow<List<Movie>>

    fun observeTopRatedMovies(): Flow<List<Movie>>

    fun observeUpcomingMovies(): Flow<List<Movie>>

    suspend fun fetchNowPlayingMovies()

    suspend fun fetchPopularMovies()

    suspend fun fetchTopRatedMovies()

    suspend fun fetchUpcomingMovies()
}