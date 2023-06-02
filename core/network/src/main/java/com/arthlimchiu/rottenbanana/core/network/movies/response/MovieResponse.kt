package com.arthlimchiu.rottenbanana.core.network.movies.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    val id: Long,
    val title: String,
    @SerialName("poster_path") val posterPath: String
)