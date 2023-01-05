package com.example.project.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project.R
import com.example.project.adapter.CategoryAdapter
import com.example.project.dao.CategoryDao
import com.example.project.dao.DbHelper
import com.example.project.dao.TaskDao
import com.example.project.databinding.ActivityWriteTaskBinding
import com.example.project.utils.showToast
import java.util.*


class ActivityWriteTask : AppCompatActivity() {
    private var categoryDao: CategoryDao? = null
    private var taskDao: TaskDao? = null
    var adapterSipnner: CategoryAdapter? = null
    lateinit var title: String
    lateinit var subTitle: String
    var priorityTask: Int = 1
    var categoryID: Int = 0
    lateinit var dateTimeCompletion: String
    var isNoti: Int = 0
    private lateinit var binding: ActivityWriteTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.actionBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.actionBar.title = "Thêm Công Việc"
        binding.actionBar.setTitleTextColor(resources.getColor(R.color.white))
        binding.actionBar.setNavigationOnClickListener {
            finish()
        }
        // binding.actionBar.elevation = getResources().getDimensionPixelSize(R.dimen.size_5dp).toFloat()
        val dbHelper = DbHelper.getInstance(this)
        categoryDao = CategoryDao.getInstance(dbHelper = dbHelper)
        taskDao = TaskDao.getInstace(dbHelper)
        adapterSipnner = CategoryAdapter(this, list = categoryDao!!.getAllCateogry())
        binding.category.adapter = adapterSipnner
        // Get Current Date
        val calenDar = Calendar.getInstance()
        val year = calenDar.get(Calendar.YEAR)
        val month = calenDar.get(Calendar.MONTH)
        val dayOfMonth = calenDar.get(Calendar.DAY_OF_MONTH)
        val mHour = calenDar.get(Calendar.HOUR_OF_DAY)
        val mMinute = calenDar.get(Calendar.MINUTE)
        adapterSipnner!!.setCallBackCategory(object : CategoryAdapter.CallbackCategory {
            override fun getIdCategory(postion: Int) {
                categoryID = postion
            }
        })
        binding.imgGreen.setOnClickListener {
            priorityTask = 1
            binding.imgGreen.setImageResource(R.drawable.ic_baseline_done_24)
            binding.imgYellow.setImageResource(0)
            binding.imgRed.setImageResource(0)
        }
        binding.imgRed.setOnClickListener {
            priorityTask = 3
            binding.imgGreen.setImageResource(0)
            binding.imgYellow.setImageResource(0)
            binding.imgRed.setImageResource(R.drawable.ic_baseline_done_24)
        }
        binding.imgYellow.setOnClickListener {
            priorityTask = 1
            binding.imgGreen.setImageResource(0)
            binding.imgYellow.setImageResource(com.example.project.R.drawable.ic_baseline_done_24)
            binding.imgRed.setImageResource(0)
        }
        binding.tvDate.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    binding.tvDate.text =
                        dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year
                },
                year,
                month,
                dayOfMonth
            )
            datePickerDialog.show()
        }
        binding.switchNotifi.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) isNoti = 1 else isNoti = 0
        }


        binding.tvTime.setOnClickListener {
            val timePickerDialog = TimePickerDialog(
                this,
                { view, hourOfDay, minute -> binding.tvTime.setText("$hourOfDay:$minute") },
                mHour,
                mMinute,
                false
            )
            timePickerDialog.show()
        }

        title = binding.edtTitle.text.toString()
        subTitle = binding.edtSubtitle.text.toString()
        dateTimeCompletion = binding.tvDate.text.toString() + binding.tvTime.text.toString()
        binding.dontNote.setOnClickListener {
            if (taskDao!!.insertTask(
                    title,
                    subTitle,
                    priorityTask,
                    categoryID,
                    calenDar.time.toString(),
                    dateTimeCompletion,
                    0,
                    isNoti
                )
            ) showToast(this, "Thêm công việc thành công") else showToast(this, "Thêm công việc thất bại")
        }
    }
}