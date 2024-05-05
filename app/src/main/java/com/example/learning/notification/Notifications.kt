package com.example.learning.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.learning.R

class Notifications : AppCompatActivity() {
    private lateinit var btnNotify: Button
    private lateinit var notificationManager: NotificationManager
    private lateinit var notificationChannel: NotificationChannel
    private lateinit var builder: Notification.Builder
//    private lateinit var remoteCollapseViews: RemoteViews
//    private lateinit var remoteExpandViews: RemoteViews
    private lateinit var pendingIntent: PendingIntent
    private lateinit var soundUri: Uri // Uniform Resource Identifier
    private lateinit var audioAttr: AudioAttributes
//    private lateinit var remoteInput: RemoteInput
    private var channelId = "Channel ID"
    private var description = "Testing Notification"
    private var title = "Notificatoin"
//    private var myKey = "Remote Key"
    private var notificationId = 1234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        btnNotify = findViewById(R.id.btnNotify)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        btnNotify.setOnClickListener {
            val intent = Intent(this, NotifyMain::class.java)
            pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

            soundUri = Uri.parse(
                ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + applicationContext.packageName + "/" + R.raw.notification
            )

            audioAttr = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .build()

            myNotificationChannel()

            notificationManager.notify(notificationId, builder.build())

        }

    }

    private fun myNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel =
                NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(true)
            notificationChannel.setSound(soundUri, audioAttr)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this, channelId)
                .setSmallIcon(R.drawable.baseline_adb_24)
                .setContentTitle(title)
                .setContentText(description)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        this.resources,
                        R.drawable.baseline_home_24
                    )
                )
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        } else {
            builder = Notification.Builder(this)
                .setSmallIcon(R.drawable.baseline_search_24)
                .setContentTitle(title)
                .setContentText(description)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources,
                    R.drawable.baseline_exit_to_app_24
                ))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        }
    }
}