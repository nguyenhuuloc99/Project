package com.example.project.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.R
import com.example.project.adapter.TaskAdapter
import com.example.project.dao.DbHelper
import com.example.project.dao.TaskDao
import com.example.project.databinding.FragmentHomeBinding
import com.example.project.databinding.ItemCvBinding
import com.example.project.model.Task
import com.example.project.utils.showToast


class FragmentHome : Fragment() {
    lateinit var binding: FragmentHomeBinding
    var taskAdapter: TaskAdapter? = null
    var listTask = ArrayList<Task>()
    var taskDao: TaskDao? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val dbHelper = context?.let { DbHelper.getInstance(it) }
        taskDao = dbHelper?.let { TaskDao.getInstace(it) }
        if (taskDao != null) {
            listTask = taskDao!!.getAllTask()
        }
        binding.btnInsert.setOnClickListener {
            startActivityForResult(Intent(context, ActivityWriteTask::class.java), 2)
            taskAdapter =
                TaskAdapter(listTask, this.requireActivity(), object : TaskAdapter.CallBackTask {
                    override fun onClick(position: Int) {
                        val bottomTask = BottomTaskDialog()
                        fragmentManager?.let { bottomTask.show(it, "") }
                        context?.showToast(requireContext(), "onclick ${position}")
                    }
                })
        }
        if (listTask.size == 0) {
            binding.reTask.visibility = View.GONE
            binding.llNotTask.visibility = View.VISIBLE
        }
        binding.reTask.adapter = taskAdapter
        binding.reTask.layoutManager = GridLayoutManager(context, 2)
        return binding.root
    }

}
/*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (isAdded && activity != null) {
        if (requestCode == 2 && resultCode == Activity.RESULT_OK && data != null) {
            val result: String? = data.getStringExtra(ActivityWriteTask.EXTRA_DATA)
            if (!result.isNullOrEmpty() && result.equals("ok")) {
                listTask = taskDao!!.getAllTask()
                binding.reTask.adapter?.notifyDataSetChanged()
            }
        }
    }

}*/


