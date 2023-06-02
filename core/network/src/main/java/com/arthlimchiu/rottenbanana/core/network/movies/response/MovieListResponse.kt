package com.arthlimchiu.rottenbanana.core.network.movies.response

import kotlinx.serialization.Serializable

@Serializable
data class MovieListResponse(
    val results: List<MovieResponse>
)