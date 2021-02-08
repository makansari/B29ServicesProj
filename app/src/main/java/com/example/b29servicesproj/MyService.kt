package com.example.b29servicesproj

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

//Normal Service or Started Service
class MyService : Service() {

     lateinit var mp : MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()
        mp = MediaPlayer.create(this,R.raw.mymusic)
        Toast.makeText(this,"service created",Toast.LENGTH_SHORT).show()
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Toast.makeText(this,"service started",Toast.LENGTH_SHORT).show()
        mp.start()

    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"service destroyed",Toast.LENGTH_SHORT).show()
        mp.stop()

    }
}