package com.example.myhealth.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myhealth.R
import com.example.myhealth.ui.list.ListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, ListFragment())
                .commit()

        }
    }
}