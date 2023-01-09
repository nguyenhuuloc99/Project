package com.example.project.customview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.adapter.GiftCategoryAdapter
import com.example.project.dao.DbHelper
import com.example.project.dao.GiftCategoryDao
import com.example.project.databinding.BottomSheetGiftBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetGift : BottomSheetDialogFragment() {
    private lateinit var binding: BottomSheetGiftBinding
    private lateinit var adapter: GiftCategoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetGiftBinding.inflate(LayoutInflater.from(context))
        binding.recyerview.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.imageClose.setOnClickListener { dismiss() }
        val dbHelper = DbHelper.getInstance(requireContext())
        val giftCategoryDao = GiftCategoryDao.getInstance(dbHelper)
        adapter = GiftCategoryAdapter(giftCategoryDao.getAllCateogry())
        binding.recyerview.adapter = adapter
        return binding.root
    }
}