package com.example.project.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project.R
import com.example.project.adapter.Discovery_Adapter
import com.example.project.databinding.FragmentDiscoveryBinding
import com.example.project.model.Discovery

class FragmentDiscovery : Fragment() {

    lateinit var binding: FragmentDiscoveryBinding
    lateinit var discoveryAdapter : Discovery_Adapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDiscoveryBinding.inflate(inflater, container, false)
        discoveryAdapter = Discovery_Adapter(getList())
        binding.re.apply {
            layoutManager = GridLayoutManager(requireContext(),2)
            adapter = discoveryAdapter
        }
        return binding.root
    }
    private fun getList(): ArrayList<Discovery> {
        var list = ArrayList<Discovery>()
        list.add(Discovery(R.drawable.schedule,"Ngày này\nnăm xưa"))
        list.add(Discovery(R.drawable.book,"Ca dao\ntục ngữ"))
        list.add(Discovery(R.drawable.traditional,"Lễ hội\ntruyền thống"))
        list.add(Discovery(R.drawable.traditional_dance,"Phong tục\ntập quán"))
        list.add(Discovery(R.drawable.gift,"Quà Tặng"))
        list.add(Discovery(R.drawable.hourglass,"Đếm xuôi\nđếm ngược"))
        return list
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentDiscovery().apply {
                arguments = Bundle().apply {

                }
            }
    }
}