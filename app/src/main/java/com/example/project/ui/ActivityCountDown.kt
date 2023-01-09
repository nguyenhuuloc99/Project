package com.example.project.ui

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.project.R
import com.example.project.databinding.ActivityCountDownBinding
import java.text.SimpleDateFormat
import java.util.*

class ActivityCountDown : AppCompatActivity() {
    private lateinit var binding: ActivityCountDownBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountDownBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.actionBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.actionBar.title = "Đếm xuôi đếm ngược"
        binding.actionBar.setTitleTextColor(resources.getColor(R.color.white))

    }
}