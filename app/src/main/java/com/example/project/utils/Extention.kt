package com.example.project.utils

import android.content.Context
import android.widget.Toast

fun Context.showToast(context: Context,string : String) {
    Toast.makeText(context,string,Toast.LENGTH_SHORT).show()
}