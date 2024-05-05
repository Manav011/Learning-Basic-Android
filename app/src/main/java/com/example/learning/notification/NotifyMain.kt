package com.example.learning.notification

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.learning.R

class NotifyMain : AppCompatActivity() {
    private lateinit var notificationManager: NotificationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notify_main)

        val txtView = findViewById<TextView>(R.id.textView1)
        val notificationId = intent.getIntExtra("notificationId",-1)
        val myKey = intent.getStringExtra("mykey")
        val bundel : Bundle? = RemoteInput.getResultsFromIntent(intent)
        if(bundel != null && myKey != null){
            val inputText = bundel.getCharSequence(myKey)
            txtView.text = inputText
        }
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(notificationId != -1){
            notificationManager.cancel(notificationId)
        }
    }
}