package com.example.project.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project.R
import com.example.project.adapter.AdapterCoutDownList
import com.example.project.databinding.ActivityCountDownListBinding
import com.example.project.model.Event

class ActivityCountDownList : AppCompatActivity() {
    private lateinit var binding: ActivityCountDownListBinding
    private lateinit var adapterCountDownList: AdapterCoutDownList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountDownListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.actionBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.actionBar.title = "Danh sách sự kiện "
        binding.actionBar.setTitleTextColor(resources.getColor(R.color.white))
        binding.actionBar.setNavigationOnClickListener {
            finish()
        }
        adapterCountDownList = AdapterCoutDownList(this,getList())
        binding.run {
            reCoutDownList.layoutManager = GridLayoutManager(this@ActivityCountDownList, 2)
            reCoutDownList.adapter = adapterCountDownList
            reCoutDownList.setHasFixedSize(true)
        }
    }

    private fun getList(): List<Event> {
        var list = ArrayList<Event>()
        list.add(Event(1,"Sinh Nhật Bạn","15/4/2023"))
        list.add(Event(2,"Đi du lịch ","15/4/2023"))
        list.add(Event(3,"Ngày tốt nghiệp","3/3/2023"))
        list.add(Event(4,"Ngày 8/3","8/3/2023"))
        return list
    }
}