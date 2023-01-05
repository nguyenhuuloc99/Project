package com.example.project.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project.R
import com.example.project.databinding.ActivityPolicyBinding

class ActivityPolicy : AppCompatActivity() {
    private lateinit var binding: ActivityPolicyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPolicyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.actionBar.title = "Chính sách và điều khoản sử dụng"
        binding.actionBar.setTitleTextColor(resources.getColor(R.color.white))
        binding.actionBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.actionBar.setNavigationOnClickListener {
            finish()
        }
    }
}