package com.example.project.ui

import android.app.*
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.project.R
import com.example.project.adapter.CategoryAdapter
import com.example.project.dao.CategoryDao
import com.example.project.dao.DbHelper
import com.example.project.dao.TaskDao
import com.example.project.databinding.ActivityWriteTaskBinding
import com.example.project.utils.*
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
        createNotificationChannel()
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
              /*  title = binding.edtTitle.text.toString()
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
                } else showToast(this@ActivityWriteTask, "Thêm công việc thất bại")*/

            }

        })
        binding.submitButton.setOnClickListener {
            scheduleNotification()
        }


    }

    private fun scheduleNotification() {
        val intents = Intent(applicationContext, com.example.project.utils.Notification::class.java)
         val titles = binding.titleET.text.toString()
         val messages = binding.messageET.text.toString()

        intents.putExtra(titleExtra, titles)
        intents.putExtra(messageExtra, messages)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            notificationID,
            intents,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time: Long = getTime()


        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP, time, pendingIntent
        )
        showAlert(time, titles, messages)
    }
    private fun getTime(): Long
    {
        val minute = binding.timePicker.minute
        val hour = binding.timePicker.hour
        val day = binding.datePicker.dayOfMonth
        val month = binding.datePicker.month
        val year = binding.datePicker.year

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)
        return calendar.timeInMillis
    }

    companion object {
        val EXTRA_DATA = "EXTRA_DATA"

    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        super.onBackPressed()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notif Channel"
            val desc = "A Description of the Channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelID, name, importance)
            channel.description = desc
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }
      /*  val name = "Notif Channel"
        val desc = "A Description of the Channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelID, name, importance)
        channel.description = desc
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)*/
    }

    private fun showAlert(time: Long, title: String, message: String) {
        val date = Date(time)
        val dateFormat = android.text.format.DateFormat.getLongDateFormat(applicationContext)
        val timeFormat = android.text.format.DateFormat.getTimeFormat(applicationContext)

        AlertDialog.Builder(this)
            .setTitle("Notification Scheduled")
            .setMessage(
                "Title: " + title +
                        "\nMessage: " + message +
                        "\nAt: " + dateFormat.format(date) + " " + timeFormat.format(date)
            )
            .setPositiveButton("Okay") { _, _ -> }
            .show()
    }
}