package com.example.project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ItemCountDownListBinding
import com.example.project.model.Event

class AdapterCoutDownList(val listEvent: List<Event>) :
    RecyclerView.Adapter<AdapterCoutDownList.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCountDownListBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCountDownListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(listEvent[position]) {
                binding.tvDate.text = dateTime
                binding.processBar.max = 120
                binding.processBar.setProgress(60)
                binding.tvEvent.text = nameEvent
            }
        }
    }

    override fun getItemCount(): Int {
        return listEvent.size
    }

}