package com.example.project.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.R
import com.example.project.adapter.WishAdapter
import com.example.project.dao.DbHelper
import com.example.project.dao.WishDao
import com.example.project.databinding.FragmentWishesBinding


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentWishes.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentWishes : Fragment() {
    private lateinit var binding: FragmentWishesBinding
    private lateinit var wishAdapter: WishAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentWishesBinding.inflate(layoutInflater, container, false)
        val dbHelper = DbHelper.getInstance(requireContext())
        val wishDao = WishDao.getInstace(dbHelper)
        binding.reWish.layoutManager = LinearLayoutManager(requireContext())
        wishAdapter = WishAdapter(wishDao.getAllWish(),requireContext())
        binding.reWish.adapter = wishAdapter
        return binding.root
    }
}