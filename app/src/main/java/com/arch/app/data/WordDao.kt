package com.arch.app.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WordDao {
    @Query("SELECT * FROM feed")
    fun getAll(): List<FeedItem>

    @Query("SELECT * FROM feed")
    fun loadAllByIds(): List<FeedItem>

    @Query("SELECT * FROM feed WHERE first_name LIKE :first LIMIT 1")
    fun findByName(first: String): FeedItem

    @Insert
    fun insertAll(users: List<FeedItem>)

    @Delete
    fun delete(user: FeedItem)
}