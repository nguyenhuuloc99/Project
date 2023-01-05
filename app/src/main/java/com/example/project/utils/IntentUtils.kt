package com.example.project.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.project.model.Task
import com.example.project.ui.ActivityPolicy
import com.example.project.ui.ActivityTimer

class IntentUtils {
    companion object {
       fun toActivityPolicy(activity: Activity) {
           val intent = Intent(activity, ActivityPolicy::class.java)
           activity.startActivity(intent)
       }
        fun toActivityTimer(activity: Activity) {
            val intent = Intent(activity, ActivityTimer::class.java)
            activity.startActivity(intent)
        }
    }
}