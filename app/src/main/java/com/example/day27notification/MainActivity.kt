package com.example.day27notification

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    val CHANNEL_ID="channelId"
    val CHANNEL_NAME="channelName"
    val notificationId=0

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()

        val notification=NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Aur Kaise Ho?")
            .setContentText("Apna Khayal Rakho")
            .setSmallIcon(R.drawable.baseline_waving_hand_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        val notificationManager=NotificationManagerCompat.from(this)
        val btn=findViewById<Button>(R.id.button)
        btn.setOnClickListener {

            notificationManager.notify(notificationId,notification)
        }

    }
    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O)
        {
            val channel = NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply{

                description="This is my Notification Channel by Aman Nishad"
                lightColor= Color.GREEN
                enableLights(true)
            }

            val manager= getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

    }
}