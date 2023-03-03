package com.example.project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.project.R
import com.example.project.model.Photo
import com.squareup.picasso.Picasso


class ImageViewPager(var listPhoto: ArrayList<Photo>, val context: Context) : PagerAdapter() {
    override fun getCount(): Int {
        return listPhoto.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view =  LayoutInflater.from(context).inflate(R.layout.item_image,container,false)
        val image : ImageView = view.findViewById(R.id.image)
        Picasso.get().load(listPhoto[position].imageURL).fit().centerCrop().into(image)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}