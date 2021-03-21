package com.arch.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arch.app.views.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.flContainer, HomeFragment()).commit()
    }
}