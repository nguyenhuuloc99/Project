package com.example.project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.GiftItemBinding
import com.example.project.model.Gift
import com.squareup.picasso.Picasso

class GiftAdapter(private val lístGift: ArrayList<Gift>) :
    RecyclerView.Adapter<GiftAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: GiftItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GiftItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(lístGift[position]) {
               Picasso.get().load(url).into(binding.imageGif)
            }
        }
    }

    override fun getItemCount(): Int {
        return lístGift.size
    }
}