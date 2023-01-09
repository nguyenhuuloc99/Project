package com.example.project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ItemGiftBottomBinding
import com.example.project.model.GiftCategory
import com.squareup.picasso.Picasso

class GiftCategoryAdapter(var listGiftCategory: ArrayList<GiftCategory>) :
    RecyclerView.Adapter<GiftCategoryAdapter.Viewholder>() {

    inner class Viewholder(val binding: ItemGiftBottomBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val binding =
            ItemGiftBottomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        with(holder) {
            with(listGiftCategory[position]) {
                Picasso.get().load(imageView).into(binding.imageGift)
                binding.tvGift.text = name
            }
        }
    }

    override fun getItemCount(): Int {
        return listGiftCategory.size
    }
}