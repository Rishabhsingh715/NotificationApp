package com.cv.notificationapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import com.cv.notificationapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


  //1 register the notification with the system..
        val nm: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

  //2 verified for api 26 or greater and created  Notificationchannel;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
         nm.createNotificationChannel(NotificationChannel("first","default",
         NotificationManager.IMPORTANCE_DEFAULT))
            Log.d("yo","i am oreo")
        }
   //3 made the notification on the click of the button
     binding.btn1.setOnClickListener {
         Log.d("yo","button clicked")
         val simpleNotification = NotificationCompat.Builder(this,"first")
                 .setContentTitle("Aasaan hai!!")
                 .setContentText("iss duniya mein na to kuchh mushkil hai na aasaan hai")
                 .setSmallIcon(R.drawable.ic_launcher_foreground)
                 .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                 .build()

         nm.notify(1,simpleNotification)

     }




    }
}