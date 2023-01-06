package com.example.project.customview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.project.ui.FragmentWishes
import com.example.project.ui.Fragment_Gift_Card

class GiftAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 2;
    }

    override fun getItem(position: Int): Fragment {
        return if (position == 0) Fragment_Gift_Card() else FragmentWishes()
    }

    override fun getPageTitle(position: Int): CharSequence {
        val title: String = if (position == 0) "Thiệp Chúc Mừng" else "Lời Chúc"
        return title
    }
}