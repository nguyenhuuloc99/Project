package com.example.project.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityBlogWriteBinding

class ActivityBlogWrite : AppCompatActivity() {
    private lateinit var binding: ActivityBlogWriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}