package com.arthlimchiu.rottenbanana.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "upcoming")
data class UpcomingEntity(
    @PrimaryKey val id: Long
)