package com.arch.app.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feed")
data class FeedItem(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    @ColumnInfo(name = "first_name") val name: String?
)