package com.arthlimchiu.rottenbanana.core.network.retrofit

import com.arthlimchiu.rottenbanana.core.network.movies.response.MovieListResponse
import retrofit2.http.GET

interface TmdbApi {

    @GET("movie/now_playing")
    suspend fun fetchNowPlayingMovies(): MovieListResponse

    @GET("movie/popular")
    suspend fun fetchPopularMovies(): MovieListResponse

    @GET("movie/top_rated")
    suspend fun fetchTopRatedMovies(): MovieListResponse

    @GET("movie/upcoming")
    suspend fun fetchUpcomingMovies(): MovieListResponse
}