package com.arthlimchiu.rottenbanana.core.network.retrofit

import com.arthlimchiu.rottenbanana.core.network.AppNetworkDataSource
import com.arthlimchiu.rottenbanana.core.network.movies.response.MovieResponse
import javax.inject.Inject

class RetrofitAppNetwork @Inject constructor(private val api: TmdbApi) : AppNetworkDataSource {

    override suspend fun fetchNowPlayingMovies(): List<MovieResponse> = api.fetchNowPlayingMovies().results

    override suspend fun fetchPopularMovies(): List<MovieResponse> = api.fetchPopularMovies().results

    override suspend fun fetchTopRatedMovies(): List<MovieResponse> = api.fetchTopRatedMovies().results

    override suspend fun fetchUpcomingMovies(): List<MovieResponse> = api.fetchUpcomingMovies().results
}