package com.arthlimchiu.rottenbanana.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "top_rated")
data class TopRatedEntity(
    @PrimaryKey val id: Long
)