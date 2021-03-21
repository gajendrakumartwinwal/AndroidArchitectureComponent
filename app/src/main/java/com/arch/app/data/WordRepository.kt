package com.arch.app.data


class WordRepository(private val wordDao: WordDao) {

    fun insertAll(items: List<FeedItem>?) {
        if(items != null )wordDao.insertAll(items)
    }

    fun getAll(): List<FeedItem> {
        return wordDao.getAll()
    }


}