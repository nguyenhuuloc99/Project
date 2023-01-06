package com.example.project.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.project.adapter.GiftAdapter
import com.example.project.dao.DbHelper
import com.example.project.dao.GiftDao
import com.example.project.databinding.FragmentGiftCardBinding
import com.example.project.model.Gift

class Fragment_Gift_Card : Fragment() {
    private var binding: FragmentGiftCardBinding? = null
    private lateinit var adapterGift: GiftAdapter
    private lateinit var listGift: ArrayList<Gift>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGiftCardBinding.inflate(layoutInflater)
        val dbHelper = DbHelper.getInstance(requireContext())
        var giftDao = GiftDao.getInstance(dbHelper)
        listGift = giftDao.getAllGIFT()
        adapterGift = GiftAdapter(listGift)
        binding?.apply {
            reGift.apply {
                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                setHasFixedSize(true)
                adapter = adapterGift
            }
        }
        return binding!!.root
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_Gift_Card().apply {

            }
    }
}