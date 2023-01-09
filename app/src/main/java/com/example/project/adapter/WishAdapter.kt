package com.example.project.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ItemWishBinding
import com.example.project.model.Wish
import com.example.project.utils.showToast


class WishAdapter(val listWish: ArrayList<Wish>, val context: Context) :
    RecyclerView.Adapter<WishAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemWishBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWishBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(listWish[position]) {
                binding.tvWish.text = wish
                binding.tvWish.setOnClickListener {
                    val myClipboard: ClipboardManager =
                        context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                    val clipData = ClipData.newPlainText("text", binding.tvWish.text)
                    myClipboard.setPrimaryClip(clipData)
                    context.showToast(context, "Text copied to clipboard")
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listWish.size
    }

}