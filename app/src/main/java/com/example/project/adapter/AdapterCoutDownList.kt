package com.example.project.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.databinding.ItemCountDownListBinding
import com.example.project.model.Event
import com.example.project.utils.DateUltil
import com.example.project.utils.IntentUtils
import java.util.*

class AdapterCoutDownList(val context : Context,val listEvent: List<Event>) :
    RecyclerView.Adapter<AdapterCoutDownList.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCountDownListBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCountDownListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(listEvent[position]) {
                val date = DateUltil.stringToDate("dd/MM/yyyy",dateTime);
              val dateUltil =  DateUltil.differenceDay(date)
                binding.tvDate.text = dateTime
                if (id % 2 ==0) {
                    binding.processBar.progressDrawable = context.getDrawable(R.drawable.progressbar_onboarding_view)
                }  else {
                    binding.processBar.progressDrawable = context.getDrawable(R.drawable.progressbar_onboarding_view_2)
                }
                binding.processBar.max = 100
                binding.processBar.setProgress(dateUltil.toInt())
                binding.tvEvent.text = nameEvent
                binding.tvDateDiff.text = dateUltil.toString()
                binding.card.setOnClickListener {
                    IntentUtils.toActivityCountDownTimer(context as Activity, event = listEvent[position])
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listEvent.size
    }

}