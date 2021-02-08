package com.example.b29servicesproj

import android.app.IntentService
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class MyIntentService : IntentService("myservicethread") {

    override fun onHandleIntent(intent: Intent?) {

        for (i in 0..10){

            Thread.sleep(1000)

        }


        //Toast.makeText(this,"OnHandle Intent", Toast.LENGTH_SHORT).show()

    }

    lateinit var mp : MediaPlayer

    override fun onCreate() {
        super.onCreate()
        mp = MediaPlayer.create(this,R.raw.mymusic)
        Toast.makeText(this,"service created", Toast.LENGTH_SHORT).show()
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Toast.makeText(this,"service started", Toast.LENGTH_SHORT).show()
        mp.start()

    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"service destroyed", Toast.LENGTH_SHORT).show()
       mp.stop()

    }
}