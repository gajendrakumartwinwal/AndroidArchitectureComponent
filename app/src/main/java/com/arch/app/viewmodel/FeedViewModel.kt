package com.arch.app.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.arch.app.MyApplication
import com.arch.app.data.AppDatabase
import com.arch.app.data.FeedItem
import com.arch.app.data.WordRepository
import com.arch.app.network.GithubRepository
import com.arch.app.network.MockedGithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel {
    var feedLiveData: LiveData<List<FeedItem>>
    val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    var db: AppDatabase

    constructor() {
        db = Room.databaseBuilder(
            MyApplication.myApplication,
            AppDatabase::class.java, "wikipages"
        ).build()
        feedLiveData = WordRepository(db.userDao()).getAllLiveData()
//        feedLiveData = MutableLiveData<List<FeedItem>>()
    }

    fun fetchData() {
        coroutineScope.launch {
            try {
                var response = GithubRepository().service.listRepos().execute()
//                var response = MockedGithubRepository().service.listRepos().execute()
                WordRepository(db.userDao()).insertAll(response.body())
            } catch (e: Exception) {
                Log.d("FDA", e.toString())
            }
        }
    }
}