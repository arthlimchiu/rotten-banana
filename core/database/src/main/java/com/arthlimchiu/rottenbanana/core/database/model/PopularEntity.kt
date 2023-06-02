package com.arthlimchiu.rottenbanana.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular")
data class PopularEntity(
    @PrimaryKey val id: Long
)