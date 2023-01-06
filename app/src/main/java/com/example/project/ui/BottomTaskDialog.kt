package com.example.project.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.project.dao.DbHelper
import com.example.project.dao.TaskDao
import com.example.project.databinding.BottomTaskBinding
import com.example.project.utils.showToast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomTaskDialog : BottomSheetDialogFragment() {

    interface CallBackBottomTask {
       fun updateTask()
    }
    var callBackBottomTask : CallBackBottomTask? = null
    set(value) {
        field =callBackBottomTask
    }
    private lateinit var binding: BottomTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomTaskBinding.inflate(layoutInflater, container, false)
        val bundle = arguments
        val id : Int = bundle!!.getInt("Id")
        val dbHelper = DbHelper.getInstance(requireContext())
        val taskDao = TaskDao.getInstace(dbHelper)

        binding.deleteTask.setOnClickListener {
            if (taskDao.deleteTask(id)) {
                callBackBottomTask?.updateTask()
                context?.showToast(requireContext(),"Xóa thành công")
            } else {
                context?.showToast(requireContext(),"Thất Bại")
            }
           dismiss()
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }
        return binding.root
    }
}