package com.arch.app

import android.app.Application

class MyApplication : Application() {

    companion object {
        lateinit var myApplication: MyApplication
        fun getApplication(): MyApplication {
            return myApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        AppExecuter()
        myApplication = this
    }
}