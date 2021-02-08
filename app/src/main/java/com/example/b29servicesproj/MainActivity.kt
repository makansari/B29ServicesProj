package com.example.b29servicesproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener {

            var myInent = Intent(this,MyService::class.java)
            startService(myInent)

        }

        buttonStop.setOnClickListener {
            var myIntent = Intent(this, MyService::class.java)
            stopService(myIntent)
        }
    }
}