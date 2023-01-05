package com.example.project.customview

import android.content.Context
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import com.example.project.databinding.MenuLeftViewBinding

class MenuLeftView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attributeSet, defStyle) {
    private lateinit var binding: MenuLeftViewBinding

    init {
        initView(attributeSet)
    }

    private fun initView(attributeSet: AttributeSet?) {
        binding = MenuLeftViewBinding.inflate(LayoutInflater.from(context), this, true)
        setInitLayoutSize()
    }

    private fun setInitLayoutSize() {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = (displayMetrics.widthPixels * 0.8).toInt()
        val layoutParams = LayoutParams(width, ViewGroup.LayoutParams.MATCH_PARENT)
        binding.layoutMain.layoutParams = layoutParams
        binding.layoutMain.orientation = VERTICAL
    }
}