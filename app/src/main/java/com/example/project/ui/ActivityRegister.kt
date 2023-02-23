package com.example.project.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project.dao.DbHelper
import com.example.project.dao.UserDao
import com.example.project.databinding.ActivityRegisterBinding
import com.example.project.utils.IntentUtils

class ActivityRegister : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageBack.setOnClickListener { finish() }
        val userName = binding.edtName.text.toString()
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()
        val dbHelper = DbHelper.getInstance(this)
        val userDao = UserDao.getInstace(dbHelper)
        binding.btnRegister.setOnClickListener {
            val isRegister = userDao.registerUser(userName, email, password, "")
            if (isRegister) IntentUtils.toActivityHome(this) else Toast.makeText(
                this,
                "Đăng kí không thành công",
                Toast.LENGTH_SHORT
            ).show()

        }
    }
}