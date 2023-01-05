package com.example.project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.databinding.ItemCvBinding
import com.example.project.databinding.ItemTaskBinding
import com.example.project.model.Task

class TaskAdapter(private val taskList: ArrayList<Task>, val context: Context) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(taskList[position]) {
               binding.noteTitle.text = title
               binding.noteSubtitle.text = title
               binding.noteDate.text = dateTimeCompletion
                when (priority) {
                    1 -> binding.notePriority.setBackgroundResource(R.drawable.red_shape)
                    2 -> binding.notePriority.setBackgroundResource(R.drawable.yellow_shape)
                    3 -> binding.notePriority.setBackgroundResource(R.drawable.green_shape)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}