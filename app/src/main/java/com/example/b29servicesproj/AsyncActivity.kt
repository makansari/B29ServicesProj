package com.example.b29servicesproj

import android.content.IntentFilter
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Filter
import kotlinx.android.synthetic.main.activity_async.*

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        var filter = IntentFilter("android.intent.action.AIRPLANE_MODE")
        var myreceiver = MyReceiver()
        registerReceiver(myreceiver,filter)



        progressBar.visibility = View.GONE

        buttonAsync.setOnClickListener {

            var mytask = MyTask()
            mytask.execute()

        }
    }


   inner class MyTask : AsyncTask<String,Int,String>(){

       override fun onPreExecute() {
           super.onPreExecute()

           progressBar.visibility = View.VISIBLE
       }

        override fun doInBackground(vararg params: String?): String {

            for(i in 1..10){
                Thread.sleep(1000)
                publishProgress(i)
            }
            var downloadedString = "Downloaded the Data"
            return downloadedString
        }

       override fun onProgressUpdate(vararg values: Int?) {
           super.onProgressUpdate(*values)

           var data = values[0]
           textViewAsyncRes.setText("downloading $data %")
       }

       override fun onPostExecute(result: String?) {
           super.onPostExecute(result)

           progressBar.visibility = View.GONE

           textViewAsyncRes.setText(result)
       }


    }
}