package com.arthlimchiu.rottenbanana.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arthlimchiu.rottenbanana.core.database.dao.MoviesDao
import com.arthlimchiu.rottenbanana.core.database.model.MovieEntity
import com.arthlimchiu.rottenbanana.core.database.model.NowPlayingEntity
import com.arthlimchiu.rottenbanana.core.database.model.PopularEntity
import com.arthlimchiu.rottenbanana.core.database.model.TopRatedEntity
import com.arthlimchiu.rottenbanana.core.database.model.UpcomingEntity

@Database(
    entities = [
        MovieEntity::class,
        NowPlayingEntity::class,
        PopularEntity::class,
        TopRatedEntity::class,
        UpcomingEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}