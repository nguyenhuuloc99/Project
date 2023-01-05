package com.example.project.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project.R
import com.example.project.adapter.GiftAdapter
import com.example.project.databinding.FragmentGiftCardBinding
import com.example.project.model.Gift

class Fragment_Gift_Card : Fragment() {
    private var binding: FragmentGiftCardBinding? = null
    private lateinit var adapterGift: GiftAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGiftCardBinding.inflate(layoutInflater)

        adapterGift = GiftAdapter(getList())
        binding?.apply {
            reGift.apply {
                layoutManager = GridLayoutManager(requireContext(), 2)
                setHasFixedSize(true)
                adapter = adapterGift
            }
        }
        return binding!!.root
    }

    private fun getList(): ArrayList<Gift> {
        var list = ArrayList<Gift>()
        list.add(Gift(R.drawable.image_banner))
        list.add(Gift(R.drawable.image_banner))
        list.add(Gift(R.drawable.image_banner))
        list.add(Gift(R.drawable.image_banner))
        return list
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_Gift_Card().apply {

            }
    }
}