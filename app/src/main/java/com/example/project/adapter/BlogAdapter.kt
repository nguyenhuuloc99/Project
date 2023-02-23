package com.example.project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ItemBlogBinding
import com.example.project.model.Blog

class BlogAdapter(private val listBlog: ArrayList<Blog>) :
    RecyclerView.Adapter<BlogAdapter.ViewHolders>() {

    inner class ViewHolders(val binding: ItemBlogBinding) : RecyclerView.ViewHolder(binding.root) {
        public fun binData(blog: Blog) {
            binding.tvDay.text = blog.datetime
            binding.tvMonth.text = blog.datetime
            binding.tvTitle.text = blog.title
            binding.tvBody.text = blog.blog
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolders {
        val binding = ItemBlogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolders(binding)
    }

    override fun onBindViewHolder(holder: ViewHolders, position: Int) {
        holder.binData(listBlog[position])
    }

    override fun getItemCount(): Int {
        return listBlog.size
    }


}