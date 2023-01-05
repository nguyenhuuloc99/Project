package com.example.project.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.project.R
import com.example.project.databinding.CustomviewFillterBinding

class CustomViewFilter : LinearLayout {
    val binding = CustomviewFillterBinding.inflate(LayoutInflater.from(context))

    constructor(context: Context) : super(context, null)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.CustomViewFilter, 0, 0)
        val imageRc = a.getResourceId(R.styleable.CustomViewFilter_iconMenuFill, 0)
        val edtText = a.getString(R.styleable.CustomViewFilter_textFill)
        a.recycle()
        binding.tvText.text = edtText
        binding.imageIcon.setBackgroundResource(imageRc)
    }

}