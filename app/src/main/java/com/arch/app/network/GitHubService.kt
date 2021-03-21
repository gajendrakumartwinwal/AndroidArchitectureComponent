package com.arch.app.network

import com.arch.app.data.FeedItem
import retrofit2.Call
import retrofit2.http.GET

interface GitHubService {
    @GET("/users/octocat/repos")
    fun listRepos(): Call<List<FeedItem>>
}