package com.example.project.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project.databinding.BottomTaskBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomTaskDialog : BottomSheetDialogFragment() {

    private lateinit var binding: BottomTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomTaskBinding.inflate(layoutInflater, container, false)
        binding.llMenuSmile.setOnClickListener {
            dismiss()
        }
        return binding.root
    }
}