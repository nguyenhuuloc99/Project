package com.example.project.ui

import android.app.*
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import com.example.project.R
import com.example.project.adapter.CategoryAdapter
import com.example.project.dao.CategoryDao
import com.example.project.dao.DbHelper
import com.example.project.dao.TaskDao
import com.example.project.databinding.ActivityWriteTaskBinding
import com.example.project.utils.ReminderCalendar
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
        createNotificationChanel()
        binding.actionBar.setNavigationOnClickListener {
            finish()
        }
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
            priorityTask = 2
            binding.imgGreen.setImageResource(0)
            binding.imgYellow.setImageResource(com.example.project.R.drawable.ic_baseline_done_24)
            binding.imgRed.setImageResource(0)
        }
        title = binding.edtTitle.text.toString()
        subTitle = binding.edtSubtitle.text.toString()

        binding.tvDate.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this, { view, year, monthOfYear, dayOfMonth ->
                    binding.tvDate.text =
                        dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year
                }, year, month, dayOfMonth
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


        binding.dontNote.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                title = binding.edtTitle.text.toString()
                subTitle = binding.edtSubtitle.text.toString()
                dateTimeCompletion = binding.tvDate.text.toString() + binding.tvTime.text.toString()
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
                ) {
                    showToast(
                        context = this@ActivityWriteTask, "Thêm công việc thành công"
                    )
                    val intent = Intent()
                    intent.putExtra(EXTRA_DATA, "ok")
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                } else showToast(this@ActivityWriteTask, "Thêm công việc thất bại")
            }

        })

         //create intent
            val intent : Intent = Intent(this,ReminderCalendar::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this,0,intent,0)
            val alarmManager : AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            val timeActon = System.currentTimeMillis()
            val tenSecond = 100 *10
            alarmManager.set(AlarmManager.RTC_WAKEUP,timeActon + tenSecond,pendingIntent)

    }

    companion object {
        val EXTRA_DATA = "EXTRA_DATA"

    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        super.onBackPressed()
    }

    fun createNotificationChanel() {
        val name = "Thông báo"
        val description = "Thông báo công việc"
        val inportance = NotificationManager.IMPORTANCE_DEFAULT
        val chenal: NotificationChannel = NotificationChannel("notifi", name, inportance)
        chenal.description = description
        getSystemService(NotificationManager::class.java)?.createNotificationChannel(chenal)
    }
}