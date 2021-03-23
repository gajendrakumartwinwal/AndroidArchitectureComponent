package com.arch.app.network

import com.arch.app.data.FeedItem
var counter = 0
class MockedGitHubService {
    fun listRepos(): Exe {
        return Exe()
    }

    class Exe {
        suspend fun execute(): ItemsWrapper {
            Thread.sleep(3000)

            return ItemsWrapper()
        }
    }
    class ItemsWrapper{
        val items: ArrayList<FeedItem> = ArrayList()
        constructor(){
            for (i in 0..10) {
                items.add(FeedItem(++counter, "NAME --> " + counter))
            }
        }
        fun body(): ArrayList<FeedItem> {
            return items
        }
    }
}