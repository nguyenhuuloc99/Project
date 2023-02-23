package com.example.project.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.project.databinding.ItemDiscoveryBinding

class FragmentDiscovery : Fragment() {

    lateinit var binding: ItemDiscoveryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val dialogLoading = context?.let { ProcessBarDialog(it) }
        binding = ItemDiscoveryBinding.inflate(inflater, container, false)
        binding.countDown.setOnClickListener {
            // dialogLoading?.show()
            context?.startActivity(Intent(context, ActivityCountDownTimer::class.java))
        }
        binding.pomorodo.setOnClickListener {
            //  dialogLoading?.show()
            context?.startActivity(Intent(context, Activity_Pomorodo::class.java))
        }
        binding.gift.setOnClickListener {
            //  dialogLoading?.show()
            context?.startActivity(Intent(context, ActivityGift::class.java))
        }
        binding.blog.setOnClickListener {
            context?.startActivity(Intent(context, ActivityBlog::class.java))
        }
        return binding.root
    }
}