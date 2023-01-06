package com.example.project.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.project.R
import com.example.project.customview.GiftAdapter
import com.example.project.dao.DbHelper
import com.example.project.dao.GiftCategoryDao
import com.example.project.dao.GiftDao
import com.example.project.databinding.ActivityGiftBinding

class ActivityGift : AppCompatActivity() {
    private lateinit var giftAdapter: GiftAdapter
    lateinit var binding: ActivityGiftBinding
    lateinit var giftCategoryDao: GiftCategoryDao
    lateinit var giftDao: GiftDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGiftBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.actionBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.actionBar.title = "Quà Tặng"
        binding.actionBar.setTitleTextColor(resources.getColor(R.color.white))
        binding.actionBar.setNavigationOnClickListener {
            finish()
        }
        giftAdapter = GiftAdapter(supportFragmentManager)
        binding.viewpager.adapter = giftAdapter
        binding.tabLayout.setupWithViewPager(binding.viewpager)
        val dbHelper = DbHelper.getInstance(this)
        giftCategoryDao = GiftCategoryDao.getInstance(dbHelper)
        giftDao = GiftDao.getInstance(dbHelper)
        Log.e(">>>",giftCategoryDao.getAllCateogry().toString())
        Log.e("gift",giftDao.getAllGIFT().toString())
    }
}