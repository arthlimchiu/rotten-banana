package com.arthlimchiu.rottenbanana.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arthlimchiu.rottenbanana.core.database.model.MovieEntity
import com.arthlimchiu.rottenbanana.core.database.model.NowPlayingEntity
import com.arthlimchiu.rottenbanana.core.database.model.PopularEntity
import com.arthlimchiu.rottenbanana.core.database.model.TopRatedEntity
import com.arthlimchiu.rottenbanana.core.database.model.UpcomingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {

    @Query("SELECT * FROM now_playing")
    fun getNowPlayingMovies(): Flow<List<NowPlayingEntity>>

    @Query("SELECT * FROM popular")
    fun getPopularMovies(): Flow<List<PopularEntity>>

    @Query("SELECT * FROM top_rated")
    fun getTopRatedMovies(): Flow<List<TopRatedEntity>>

    @Query("SELECT * FROM upcoming")
    fun getUpcomingMovies(): Flow<List<UpcomingEntity>>

    @Query("SELECT * FROM movies WHERE id in (:ids)")
    fun getMovies(ids: List<Long>): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNowPlayingMovies(movies: List<NowPlayingEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(movies: List<PopularEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedMovies(movies: List<TopRatedEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpcomingMovies(movies: List<UpcomingEntity>)
}