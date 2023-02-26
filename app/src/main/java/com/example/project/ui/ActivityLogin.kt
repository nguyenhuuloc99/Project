package com.example.project.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project.dao.DbHelper
import com.example.project.dao.UserDao
import com.example.project.databinding.ActivityLoginBinding
import com.example.project.utils.IntentUtils
import com.example.project.utils.ProcessBarDialog

class ActivityLogin : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var userDao: UserDao? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dbHelper = DbHelper.getInstance(this)
        val processBarDialog = ProcessBarDialog(this)
        userDao = UserDao.getInstace(dbHelper)
        binding.tvRegisgter.setOnClickListener {
            startActivity(Intent(this, ActivityRegister::class.java))
        }
        binding.btnLogin.setOnClickListener {
            val email = binding.tvEmail.text.toString()
            val password = binding.tvPassword.text.toString()
            startActivity(Intent(this, MainActivity::class.java))

            /*processBarDialog.show()
            val email = binding.tvEmail.text.toString()
            val password = binding.tvPassword.text.toString()
            val isLogin = userDao!!.checkUser(email, password)
            if (isLogin) {
                processBarDialog.dismiss()

                finish()
            } else {
                processBarDialog.dismiss()
                Toast.makeText(
                    this,
                    "Email hoặc mật khẩu không đúng vui lòng nhập lại!",
                    Toast.LENGTH_SHORT
                ).show()
            }*/

        }
        binding.run {
            tvRegisgter.setOnClickListener {
                IntentUtils.toActivityRegister(this@ActivityLogin)
            }
        }
    }
}