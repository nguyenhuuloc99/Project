package com.example.project.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.project.databinding.FragmentGiftDetailBinding

class FragmentGiftDetail : Fragment() {
    private lateinit var binding: FragmentGiftDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGiftDetailBinding.inflate(layoutInflater)
        binding.run {
            ivShare.setOnClickListener {
                val shareIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_STREAM, "")
                    type = "image/jpeg"
                }
                startActivity(Intent.createChooser(shareIntent, null))
            }
        }
        return binding.root
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            FragmentGiftDetail().apply {
                arguments = Bundle().apply {
                }
            }
    }
}