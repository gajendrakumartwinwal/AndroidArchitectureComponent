package com.arch.app.data

import androidx.lifecycle.LiveData


class WordRepository(private val wordDao: WordDao) {

    fun insertAll(items: List<FeedItem>?) {
        if(items != null )wordDao.insertAll(items)
    }

    fun updateAll(items: List<FeedItem>?) {
        if(items != null )wordDao.updateAll(items)
    }

    fun getAll(): List<FeedItem> {
        return wordDao.getAll()
    }

    fun getAllLiveData(): LiveData<List<FeedItem>> {
        return wordDao.getAllLive()
    }


}