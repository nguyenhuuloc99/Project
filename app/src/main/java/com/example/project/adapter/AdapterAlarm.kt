package com.example.project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ItemAlarmBinding
import com.example.project.model.Alarm

class AdapterAlarm(val context: Context, var list: List<Alarm>) :
    RecyclerView.Adapter<AdapterAlarm.ViewHolder>() {
    inner class ViewHolder(val binding: ItemAlarmBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAlarmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.tvTime.text = dateTime
                binding.switchNotifi.isChecked = isNotifi
                val sb = StringBuilder()
                for (lisst in listWeekly) {
                    sb.append(lisst)
                    sb.append(" ")
                }
                val string = sb.toString()
                binding.weely.text = string
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}