package com.arch.app.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {
    @Query("SELECT * FROM feed")
    fun getAll(): List<FeedItem>

    @Query("SELECT * FROM feed")
    fun getAllLive(): LiveData<List<FeedItem>>

    @Query("SELECT * FROM feed WHERE first_name LIKE :first LIMIT 1")
    fun findByName(first: String): FeedItem

    @Insert
    fun insertAll(users: List<FeedItem>)

    @Update
    fun updateAll(users: List<FeedItem>)

    @Delete
    fun delete(user: FeedItem)
}