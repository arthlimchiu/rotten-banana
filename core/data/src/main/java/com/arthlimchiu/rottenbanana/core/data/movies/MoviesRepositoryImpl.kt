package com.arthlimchiu.rottenbanana.core.data.movies

import com.arthlimchiu.rottenbanana.core.common.Dispatcher
import com.arthlimchiu.rottenbanana.core.common.MyDispatchers.IO
import com.arthlimchiu.rottenbanana.core.database.dao.MoviesDao
import com.arthlimchiu.rottenbanana.core.database.model.MovieEntity
import com.arthlimchiu.rottenbanana.core.model.Movie
import com.arthlimchiu.rottenbanana.core.network.AppNetworkDataSource
import com.arthlimchiu.rottenbanana.core.network.movies.response.MovieResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
class MoviesRepositoryImpl @Inject constructor(
    private val moviesDao: MoviesDao,
    private val network: AppNetworkDataSource,
    @Dispatcher(IO) private val ioDispatcher: CoroutineDispatcher
) : MoviesRepository {

    override fun observeNowPlayingMovies(): Flow<List<Movie>> {
        return moviesDao
            .getNowPlayingMovies()
            .map { nowPlaying -> nowPlaying.map { it.id } }
            .flatMapLatest { moviesDao.getMovies(it).map { movies -> movies.map(MovieEntity::asExternalModel) } }
    }

    override fun observePopularMovies(): Flow<List<Movie>> {
        return moviesDao
            .getPopularMovies()
            .map { popular -> popular.map { it.id } }
            .flatMapLatest { moviesDao.getMovies(it).map { movies -> movies.map(MovieEntity::asExternalModel) } }
    }

    override fun observeTopRatedMovies(): Flow<List<Movie>> {
        return moviesDao
            .getTopRatedMovies()
            .map { topRated -> topRated.map { it.id } }
            .flatMapLatest { moviesDao.getMovies(it).map { movies -> movies.map(MovieEntity::asExternalModel) } }
    }

    override fun observeUpcomingMovies(): Flow<List<Movie>> {
        return moviesDao
            .getUpcomingMovies()
            .map { upcoming -> upcoming.map { it.id } }
            .flatMapLatest { moviesDao.getMovies(it).map { movies -> movies.map(MovieEntity::asExternalModel) } }
    }

    override suspend fun fetchNowPlayingMovies() {
        withContext(ioDispatcher) {
            val movieResponses = network.fetchNowPlayingMovies()
            moviesDao.insertMovies(movieResponses.map(MovieResponse::asMovieEntity))
            moviesDao.insertNowPlayingMovies(movieResponses.map(MovieResponse::asNowPlayingEntity))
        }
    }

    override suspend fun fetchPopularMovies() {
        withContext(ioDispatcher) {
            val movieResponses = network.fetchPopularMovies()
            moviesDao.insertMovies(movieResponses.map(MovieResponse::asMovieEntity))
            moviesDao.insertPopularMovies(movieResponses.map(MovieResponse::asPopularEntity))
        }
    }

    override suspend fun fetchTopRatedMovies() {
        withContext(ioDispatcher) {
            val movieResponses = network.fetchTopRatedMovies()
            moviesDao.insertMovies(movieResponses.map(MovieResponse::asMovieEntity))
            moviesDao.insertTopRatedMovies(movieResponses.map(MovieResponse::asTopRatedEntity))
        }
    }

    override suspend fun fetchUpcomingMovies() {
        withContext(ioDispatcher) {
            val movieResponses = network.fetchUpcomingMovies()
            moviesDao.insertMovies(movieResponses.map(MovieResponse::asMovieEntity))
            moviesDao.insertUpcomingMovies(movieResponses.map(MovieResponse::asUpcomingEntity))
        }
    }
}