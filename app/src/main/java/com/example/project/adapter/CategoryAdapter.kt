package com.example.project.adapter

import android.content.Context
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.project.R
import com.example.project.databinding.ItemCategoryBinding
import com.example.project.databinding.ItemSpinnerSelectedBinding
import com.example.project.model.Category
import java.util.*
import kotlin.collections.ArrayList

class CategoryAdapter(context: Context,  list: ArrayList<Category>) :
    ArrayAdapter<Category>(context, 0, list) {
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    interface CallbackCategory {
       fun getIdCategory(postion :Int)
    }
    var callbackCategory : CallbackCategory? = null
    fun setCallBackCategory(callbackCategory: CallbackCategory) {
        callbackCategory.also { this.callbackCategory = it }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.item_category, parent, false)
        } else {
            view = convertView
        }
        getItem(position)?.let { country ->
            setItemForCountry(view, country)
            callbackCategory!!.getIdCategory(position)
        }
        return view
    }

    override fun getItem(position: Int): Category? {
        if (position == 0) {
            return super.getItem(0)
        }
        return super.getItem(position - 1)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (position == 0) {
            view = layoutInflater.inflate(R.layout.header_category, parent, false)
            view.setOnClickListener {
                val root = parent.rootView
                root.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK))
                root.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK))
            }
        } else {
            view = layoutInflater.inflate(R.layout.item_category, parent, false)
            getItem(position)?.let { country ->
                setItemForCountry(view, country)
            }
        }
        return view
    }

    override fun getCount() = super.getCount() + 1
    override fun isEnabled(position: Int) = position != 0
    private fun setItemForCountry(view: View, category: Category) {
        val tvCategory = view.findViewById<TextView>(R.id.tv_category)
        tvCategory.text = category.name
    }
}