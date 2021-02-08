package com.example.b29servicesproj

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        Toast.makeText(context,"AIRPLAN MODE",Toast.LENGTH_LONG).show()

        var myIntent = Intent(context,MainActivity::class.java)
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context?.startActivity(myIntent)

    }
}