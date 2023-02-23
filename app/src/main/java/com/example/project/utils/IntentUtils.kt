package com.example.project.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.project.model.Task
import com.example.project.ui.ActivityBlogWrite
import com.example.project.ui.ActivityPolicy
import com.example.project.ui.ActivityTimer
import com.example.project.ui.MainActivity

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
        fun  toActivityHome(activity: Activity) {
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
        }
        fun toActivityBlog(activity: Activity) {
            val intent = Intent(activity, ActivityBlogWrite::class.java)
            activity.startActivity(intent)
        }
    }
}