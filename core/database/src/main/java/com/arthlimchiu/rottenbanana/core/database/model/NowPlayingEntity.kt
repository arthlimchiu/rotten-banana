package com.arthlimchiu.rottenbanana.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "now_playing")
data class NowPlayingEntity(
    @PrimaryKey val id: Long
)
