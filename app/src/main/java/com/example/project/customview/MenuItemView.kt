package com.example.project.customview

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.project.R
import com.example.project.databinding.MenuItemViewBinding


class MenuItemView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) :

    LinearLayout(context, attributeSet, defStyle) {
    private var itemIconId: Drawable? = null
    private var itemMainText: String? = null
    private var itemTint: ColorStateList? = null

    init {
        initView(attributeSet)
    }

    fun initView(attributeSet: AttributeSet?) {
        val binding = MenuItemViewBinding.inflate(
            LayoutInflater.from(context), this, true
        )

        val typedArray = context.theme.obtainStyledAttributes(
            attributeSet, R.styleable.MenuItemView, 0, 0
        )
        itemIconId = typedArray.getDrawable(R.styleable.MenuItemView_itemIcon)
        itemMainText = typedArray.getString(R.styleable.MenuItemView_itemMainText)
        itemTint = typedArray.getColorStateList(R.styleable.MenuItemView_itemTint)
        typedArray.recycle()
        binding.ivItemIcon.setImageDrawable(itemIconId)
        binding.tvItemMain.text = itemMainText
    }
}