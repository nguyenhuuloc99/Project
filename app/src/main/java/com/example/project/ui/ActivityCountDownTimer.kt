package com.example.project.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.project.R
import com.example.project.databinding.ActivityCountDownTimerBinding

class ActivityCountDownTimer : AppCompatActivity() {
    private lateinit var binding: ActivityCountDownTimerBinding
    lateinit var roundImage: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountDownTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.actionBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.actionBar.title = "Đếm xuôi đếm ngược"
        binding.actionBar.setTitleTextColor(resources.getColor(R.color.white))
        roundImage = AnimationUtils.loadAnimation(this, R.anim.atg)
        binding.icachor.startAnimation(roundImage)
        binding.actionBar.setNavigationOnClickListener {
            finish()
        }

    }
}