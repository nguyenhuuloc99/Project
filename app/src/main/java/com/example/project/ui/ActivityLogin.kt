package com.example.project.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project.R
import com.example.project.databinding.ActivityLoginBinding

class ActivityLogin : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvRegisgter.setOnClickListener {
            startActivity(Intent(this, ActivityRegister::class.java))
        }
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}