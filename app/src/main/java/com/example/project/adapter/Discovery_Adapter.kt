package com.example.project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ItemDiscoveryBinding
import com.example.project.model.Discovery

class Discovery_Adapter(var list: ArrayList<Discovery>) :RecyclerView.Adapter<Discovery_Adapter.ViewHolder>() {
    inner class ViewHolder(val binding :ItemDiscoveryBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDiscoveryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.image.setBackgroundResource(image)
                binding.tv.text = name
            }
        }
    }

    override fun getItemCount(): Int {
        return  list.size
    }

}