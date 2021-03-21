package com.arch.app.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(FeedItem::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): WordDao
}