package com.arthlimchiu.rottenbanana.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey val id: Long,
    val title: String,
    @ColumnInfo(name = "poster_path") val posterPath: String
)