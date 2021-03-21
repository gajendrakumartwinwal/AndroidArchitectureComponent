package com.arch.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.arch.app.MyApplication
import com.arch.app.data.AppDatabase
import com.arch.app.data.FeedItem
import com.arch.app.data.WordRepository
import com.arch.app.network.service
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    val feedLiveData = MutableLiveData<List<FeedItem>>()
    val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    val coroutineScopeMain: CoroutineScope = CoroutineScope(Dispatchers.Main)
    val db = Room.databaseBuilder(
        MyApplication.myApplication,
        AppDatabase::class.java, "wikipages"
    ).build()

    fun fetchData() {
        coroutineScope.launch {
            var feedItems: List<FeedItem>? = WordRepository(db.userDao()).getAll()
            if(feedItems == null){
                var response = service.listRepos().execute()
                WordRepository(db.userDao()).insertAll(response.body())
                feedItems = response.body()
            }

            coroutineScopeMain.launch { feedLiveData.value = feedItems }
        }
    }
}