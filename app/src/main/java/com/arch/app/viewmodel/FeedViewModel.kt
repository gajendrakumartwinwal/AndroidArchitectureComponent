package com.arch.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arch.app.data.FeedItem
import com.arch.app.network.service
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    val feedLiveData = MutableLiveData<List<FeedItem>>()
    val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    val coroutineScopeMain: CoroutineScope = CoroutineScope(Dispatchers.Main)
    fun fetchData() {
        coroutineScope.launch {
            var response = service.listRepos().execute()
            coroutineScopeMain.launch { feedLiveData.value = response.body() }
        }
    }
}