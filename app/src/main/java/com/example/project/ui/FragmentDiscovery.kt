package com.example.project.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project.R
import com.example.project.adapter.Discovery_Adapter
import com.example.project.customview.GiftAdapter
import com.example.project.databinding.FragmentDiscoveryBinding
import com.example.project.databinding.ItemDiscoveryBinding
import com.example.project.model.Discovery

class FragmentDiscovery : Fragment() {

    lateinit var binding: ItemDiscoveryBinding
    lateinit var discoveryAdapter: Discovery_Adapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = ItemDiscoveryBinding.inflate(inflater, container, false)
        binding.countDown.setOnClickListener {
            context?.startActivity(Intent(context, ActivityCountDownTimer::class.java))
        }
        binding.pomorodo.setOnClickListener {
            context?.startActivity(Intent(context, ActivityTimer::class.java))
        }
        binding.gift.setOnClickListener {
            context?.startActivity(Intent(context, ActivityGift::class.java))
        }


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = FragmentDiscovery().apply {
            arguments = Bundle().apply {

            }
        }
    }
}