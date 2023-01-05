package com.example.project.ui

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
import com.example.project.databinding.FragmentHomeBinding
import com.example.project.model.Task



class FragmentHome : Fragment() {
    lateinit var binding: FragmentHomeBinding
    var taskAdapter: TaskAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnInsert.setOnClickListener {
            context?.startActivity(Intent(context, ActivityWriteTask::class.java))
        }
        taskAdapter = TaskAdapter(getTaskList(), this.requireActivity())
        if (getTaskList().size == 0) {
            binding.reTask.visibility = View.GONE
            binding.llNotTask.visibility = View.VISIBLE
        }
        binding.reTask.adapter = taskAdapter
        binding.reTask.layoutManager = GridLayoutManager(context,2)

        return binding.root
    }

    private fun getTaskList(): ArrayList<Task> {
        var listTask = ArrayList<Task>()
        listTask.add(
            Task(
                1, "Title", "SubTitle", 1, 1, "016", "556",
                false, true
            )
        )
        listTask.add(
            Task(
                2, "Title", "SubTitle", 2, 1, "016", "556",
                false, true
            )
        )
        return listTask
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentHome().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction =
            (activity as FragmentActivity).supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}