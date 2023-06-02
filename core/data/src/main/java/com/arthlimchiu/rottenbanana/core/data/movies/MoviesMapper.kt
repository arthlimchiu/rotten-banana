package com.arthlimchiu.rottenbanana.core.data.movies

import com.arthlimchiu.rottenbanana.core.database.model.MovieEntity
import com.arthlimchiu.rottenbanana.core.database.model.NowPlayingEntity
import com.arthlimchiu.rottenbanana.core.database.model.PopularEntity
import com.arthlimchiu.rottenbanana.core.database.model.TopRatedEntity
import com.arthlimchiu.rottenbanana.core.database.model.UpcomingEntity
import com.arthlimchiu.rottenbanana.core.model.Movie
import com.arthlimchiu.rottenbanana.core.network.movies.response.MovieResponse

fun MovieEntity.asExternalModel() = Movie(
    id = id,
    title = title,
    posterPath = posterPath
)

fun MovieResponse.asMovieEntity() = MovieEntity(
    id = id,
    title = title,
    posterPath = posterPath
)

fun MovieResponse.asNowPlayingEntity() = NowPlayingEntity(
    id = id
)

fun MovieResponse.asPopularEntity() = PopularEntity(
    id = id
)

fun MovieResponse.asTopRatedEntity() = TopRatedEntity(
    id = id
)

fun MovieResponse.asUpcomingEntity() = UpcomingEntity(
    id = id
)