package com.example.project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.databinding.ItemTaskBinding
import com.example.project.model.Task

class TaskItemCalendarAdapter(
    private val taskList: ArrayList<Task>,
    val context: Context,
    val callBackTas: CallBackTask
) :
    RecyclerView.Adapter<TaskItemCalendarAdapter.ViewHolder>() {
    interface CallBackTask {
        fun onClick(position: Int)
    }


    inner class ViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(taskList[position]) {
                binding.noteTitle.text = taskList[position].title
                binding.noteSubtitle.text = taskList[position].subTitle
                binding.noteDate.text = taskList[position].dateTimeCompletion
                when (priority) {
                    1 -> binding.notePriority.setBackgroundResource(R.drawable.red_shape)
                    2 -> binding.notePriority.setBackgroundResource(R.drawable.yellow_shape)
                    3 -> binding.notePriority.setBackgroundResource(R.drawable.green_shape)
                }
                binding.root.setOnClickListener {
                    callBackTas.onClick(position)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}