package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
        Log.e("Activity","onBind")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(
            "Activity",
            "onStartCommand" + intent.toString() + "flag " + flags + "startId" + startId
        )
        return START_STICKY
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e("Activity", "OnUnbind" + intent.toString())
        return super.onUnbind(intent)
    }

    override fun onRebind(intent: Intent?) {
        Log.e("Activity", "OnRebin" + intent.toString())
        super.onRebind(intent)
    }

    override fun onCreate() {
        Log.e("Activity", "OnCreate")
        super.onCreate()
    }

    override fun onDestroy() {
        Log.e("Activity", "OnDestroy")
    }
}
