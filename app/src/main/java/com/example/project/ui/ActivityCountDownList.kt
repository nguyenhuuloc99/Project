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
        adapterCountDownList = AdapterCoutDownList(getList())
        binding.run {
            reCoutDownList.layoutManager = GridLayoutManager(this@ActivityCountDownList, 2)
            reCoutDownList.adapter = adapterCountDownList
            reCoutDownList.setHasFixedSize(true)
        }
    }

    private fun getList(): List<Event> {
        var list = ArrayList<Event>()
        list.add(Event(1,"AAAAAAAAAA","aaaaa"))
        list.add(Event(1,"AAAAAAAAAA","aaaaa"))
        list.add(Event(1,"AAAAAAAAAA","aaaaa"))
        list.add(Event(1,"AAAAAAAAAA","aaaaa"))
        return list
    }
}