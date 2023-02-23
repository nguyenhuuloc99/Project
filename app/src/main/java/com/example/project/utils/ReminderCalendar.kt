package com.example.project.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.project.R

class ReminderCalendar : BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {
        val notificationCompat : NotificationCompat.Builder? =
            context?.let {
                NotificationCompat.Builder(it, "notification")
                    .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                    .setContentTitle("Thông báo lịch làm việc")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            }
        if (notificationCompat != null) {
            context.let { NotificationManagerCompat.from(it) }
                .notify(200, notificationCompat.build())
        }
    }
}