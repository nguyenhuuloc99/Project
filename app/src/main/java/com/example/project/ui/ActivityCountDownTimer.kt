package com.example.project.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.project.R
import com.example.project.databinding.ActivityCountDownTimerBinding
import com.example.project.model.Event
import com.example.project.utils.DateUltil
import java.text.SimpleDateFormat
import java.util.*



class ActivityCountDownTimer : AppCompatActivity() {
    private lateinit var binding: ActivityCountDownTimerBinding
    lateinit var roundImage: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountDownTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.actionBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.actionBar.title = "Đếm ngược"
        binding.actionBar.setTitleTextColor(resources.getColor(R.color.white))
        roundImage = AnimationUtils.loadAnimation(this, R.anim.atg)
        binding.icachor.startAnimation(roundImage)
        binding.actionBar.setNavigationOnClickListener {
            finish()
        }
        val bundle = intent.extras
        val event : Event = bundle?.getSerializable("time") as Event

        val currentTime = Calendar.getInstance().time
        val endDateDay = event.dateTime

        val format1 = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val endDate = format1.parse(endDateDay)
        val dateDiff = endDate.time - currentTime.time
        binding.actionBar.setNavigationOnClickListener {
            finish()
        }
        binding.tvTitle.text = event.nameEvent
        val timer = object : CountDownTimer(dateDiff, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val days = String.format("%02d", millisUntilFinished / (24 * 60 * 60 * 1000))
                val hours = String.format("%02d", millisUntilFinished / (60 * 60 * 1000) % 24)
                val minutes = String.format("%02d", millisUntilFinished / (60 * 1000) % 60)
                val seconds = String.format("%02d", millisUntilFinished / 1000 % 60)
                binding.tvDay.text = days
                binding.tvHour.text = hours
                binding.tvminus.text = minutes
                binding.tvseconds.text = seconds
            }

            override fun onFinish() {

            }

        }
        timer.start()
    }
}