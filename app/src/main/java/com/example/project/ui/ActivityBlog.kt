package com.example.project.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.R
import com.example.project.adapter.BlogAdapter
import com.example.project.databinding.ActivityBlogBinding
import com.example.project.utils.IntentUtils

class ActivityBlog : AppCompatActivity() {
    private lateinit var binding: ActivityBlogBinding
    private lateinit var blogAdapter: BlogAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.reBlog.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.reBlog.adapter = blogAdapter
        binding.reBlog.setHasFixedSize(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_blog, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.create_blog) {
            IntentUtils.toActivityBlog(this)
        }
        return super.onOptionsItemSelected(item)
    }
}