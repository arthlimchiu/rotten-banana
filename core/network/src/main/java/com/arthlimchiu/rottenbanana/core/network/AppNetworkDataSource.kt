package com.arthlimchiu.rottenbanana.core.network

import com.arthlimchiu.rottenbanana.core.network.movies.response.MovieResponse

interface AppNetworkDataSource {
    suspend fun fetchNowPlayingMovies(): List<MovieResponse>

    suspend fun fetchPopularMovies(): List<MovieResponse>

    suspend fun fetchTopRatedMovies(): List<MovieResponse>

    suspend fun fetchUpcomingMovies(): List<MovieResponse>
}