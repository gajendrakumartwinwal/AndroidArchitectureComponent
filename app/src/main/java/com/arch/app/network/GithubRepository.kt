package com.arch.app.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "https://api.github.com"
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var service = retrofit.create(GitHubService::class.java)
//class GithubRepository(service: GitHubService){
//    fun getResponse(): Call<List<FeedItem>> = service.listRepos()
//}