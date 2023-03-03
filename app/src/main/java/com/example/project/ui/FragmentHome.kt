package com.example.project.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project.R
import com.example.project.adapter.TaskItemCalendarAdapter
import com.example.project.dao.DbHelper
import com.example.project.dao.TaskDao
import com.example.project.databinding.FragmentHomeBinding
import com.example.project.model.Task
import java.util.*


class FragmentHome : Fragment() {
    lateinit var binding: FragmentHomeBinding
    var taskItemCalendarAdapter: TaskItemCalendarAdapter? = null
    var listTask = ArrayList<Task>()
    var taskDao: TaskDao? = null
    lateinit var bottomTask : BottomTaskDialog
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val dbHelper = context?.let { DbHelper.getInstance(it) }
        taskDao = dbHelper?.let { TaskDao.getInstace(it) }
        if (taskDao != null) {
            listTask = taskDao!!.getAllTask()
        }
        bottomTask = BottomTaskDialog()
        taskItemCalendarAdapter =
            TaskItemCalendarAdapter(listTask, this.requireActivity(), object : TaskItemCalendarAdapter.CallBackTask {
                override fun onClick(position: Int) {
                    bottomTask = BottomTaskDialog.getInstance(position)
                    Log.e(">>>p",position.toString())
                    fragmentManager?.let { bottomTask.show(it, "") }
                 //   context?.showToast(requireContext(), "onclick ${position}")
                }
            })
        bottomTask.callBackBottomTask = object : BottomTaskDialog.CallBackBottomTask {
            @SuppressLint("NotifyDataSetChanged")
            override fun updateTask() {
                listTask.clear()
                taskDao?.let { listTask.addAll(it.getAllTask()) }
                taskItemCalendarAdapter!!.notifyDataSetChanged()
            }

        }
        binding.btnInsert.setOnClickListener {
            startActivityForResult(Intent(context, ActivityWriteTask::class.java), 2)
        }
        if (listTask.size == 0) {
            binding.reTask.visibility = View.GONE
            binding.llNotTask.visibility = View.VISIBLE
        }
        binding.reTask.adapter = taskItemCalendarAdapter
        binding.reTask.layoutManager = GridLayoutManager(context, 2)
        binding.noFilter.setBackgroundResource(R.drawable.filter_bg)
        binding.noFilter.setOnClickListener(View.OnClickListener {
            loadData(0)
            binding.hightolow.setBackgroundResource(0)
            binding.lowtohigh.setBackgroundResource(0)
            binding.noFilter.setBackgroundResource(R.drawable.filter_bg)
        })
        binding.hightolow.setOnClickListener(View.OnClickListener {
            loadData(1)
            binding.noFilter.setBackgroundResource(0)
            binding.hightolow.setBackgroundResource(R.drawable.filter_bg)
            binding.lowtohigh.setBackgroundResource(0)
        })
        binding.lowtohigh.setOnClickListener(View.OnClickListener {
            loadData(2)
            binding.noFilter.setBackgroundResource(0)
            binding.hightolow.setBackgroundResource(0)
            binding.lowtohigh.setBackgroundResource(R.drawable.filter_bg)
        })
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        listTask.clear()
        taskDao?.let { listTask.addAll(it.getAllTask()) }
        binding.reTask.adapter?.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (isAdded && activity != null) {
            if (requestCode == 2 && resultCode == Activity.RESULT_OK && data != null) {
                val result: String? = data.getStringExtra(ActivityWriteTask.EXTRA_DATA)
                if (!result.isNullOrEmpty() && result.equals("ok")) {
                    listTask.clear()
                    taskDao?.let { listTask.addAll(it.getAllTask()) }
                    taskItemCalendarAdapter?.notifyDataSetChanged()
                    binding.noFilter.setOnClickListener(View.OnClickListener {
                        loadData(0)
                        if (listTask.size == 0) {
                            binding.reTask.visibility = View.GONE
                            binding.llNotTask.visibility = View.VISIBLE
                        }
                        binding.hightolow.setBackgroundResource(0)
                        binding.lowtohigh.setBackgroundResource(0)
                        binding.noFilter.setBackgroundResource(R.drawable.filter_bg)
                    })
                }
            }
        }

    }
    companion object {
        const val Id : String = "ID"
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadData(i: Int) {
        if (i == 0) {
            listTask = taskDao?.getAllTask()!!
            taskItemCalendarAdapter?.setList(listTask)
            binding.reTask.adapter = taskItemCalendarAdapter
            taskItemCalendarAdapter?.notifyDataSetChanged()
            Log.e(">>>",listTask.size.toString())
            if (listTask.size == 0) {
                binding.reTask.visibility = View.GONE
                binding.llNotTask.visibility = View.VISIBLE
            } else {
                binding.reTask.visibility = View.VISIBLE
                binding.llNotTask.visibility = View.GONE
            }
        } else if (i == 1) {
            listTask = taskDao?.getTaskPriority("1")!!
            taskItemCalendarAdapter?.setList(listTask)
            binding.reTask.adapter = taskItemCalendarAdapter
            taskItemCalendarAdapter?.notifyDataSetChanged()
            Log.e(">>>",listTask.size.toString())
            if (listTask.size == 0) {
                binding.reTask.visibility = View.GONE
                binding.llNotTask.visibility = View.VISIBLE
            } else {
                binding.reTask.visibility = View.VISIBLE
                binding.llNotTask.visibility = View.GONE
            }
        } else if (i == 2) {
            listTask= taskDao?.getTaskPriority("2")!!
            taskItemCalendarAdapter?.setList(listTask)
            binding.reTask.adapter = taskItemCalendarAdapter
            taskItemCalendarAdapter?.notifyDataSetChanged()
            Log.e(">>>",listTask.size.toString())
            if (listTask.size == 0) {
                binding.reTask.visibility = View.GONE
                binding.llNotTask.visibility = View.VISIBLE
            } else {
                binding.reTask.visibility = View.VISIBLE
                binding.llNotTask.visibility = View.GONE
            }
        }
    }


}



