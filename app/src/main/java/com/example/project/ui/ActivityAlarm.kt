package com.example.project.ui

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TimePicker
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.R
import com.example.project.adapter.AdapterAlarm
import com.example.project.databinding.ActivityAlarmBinding
import com.example.project.model.Alarm
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.TimeZone

class ActivityAlarm : AppCompatActivity() {
    lateinit var binding: ActivityAlarmBinding
    lateinit var adapterAlarm: AdapterAlarm
    val list = ArrayList<Alarm>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.actionBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.actionBar.title = "Báo thức"
        binding.actionBar.setTitleTextColor(resources.getColor(R.color.white))
        binding.actionBar.setNavigationOnClickListener {
            finish()
        }
        adapterAlarm = AdapterAlarm(context = this, getList())
        val calendar = Calendar.getInstance()
        var hours = calendar.get(Calendar.HOUR_OF_DAY)
        var minus = calendar.get(Calendar.MINUTE)
        val timePickerDialogListener: TimePickerDialog.OnTimeSetListener =
            object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    calendar.set(Calendar.HOUR_OF_DAY, hours)
                    calendar.set(Calendar.MINUTE, minus)
                    calendar.timeZone = TimeZone.getDefault()
                    val simpleDateFormat = SimpleDateFormat("hh:mm")
                    val time = simpleDateFormat.format(calendar.time)
                    list.add(Alarm(1,time,arrayListOf("MON", "WED"),false))
                    adapterAlarm.notifyDataSetChanged()
                    Log.e(">>>>", time.toString())
                }
            }

        binding.run {
            reAlarm.layoutManager =
                LinearLayoutManager(this@ActivityAlarm, LinearLayoutManager.VERTICAL, false)
            reAlarm.adapter = adapterAlarm
            reAlarm.setHasFixedSize(true)
            btnInsert.setOnClickListener {
                val timePicker: TimePickerDialog = TimePickerDialog(
                    this@ActivityAlarm,
                    timePickerDialogListener,
                    hours,
                    minus,

                    false
                )
                timePicker.show()
            }
        }
    }

    private fun getList(): List<Alarm> {
        list.add(Alarm(1, "10:30", arrayListOf("MON", "WED"), false))
        list.add(Alarm(2, "7:30", arrayListOf("THU"), true))
        list.add(Alarm(3, "10:30", arrayListOf("FRI", "SUN"), true))
        return list
    }
}