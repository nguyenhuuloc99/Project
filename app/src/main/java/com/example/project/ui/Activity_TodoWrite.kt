package com.example.project.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.project.adapter.CategoryAdapter
import com.example.project.dao.CategoryDao
import com.example.project.dao.TaskDao
import com.example.project.databinding.ActivityTodoWriteBinding
import com.example.project.utils.IntentUtils

class Activity_TodoWrite : AppCompatActivity() {
    lateinit var binding: ActivityTodoWriteBinding
    private var categoryDao: CategoryDao? = null
    private var taskDao: TaskDao? = null
    var adapterSipnner: CategoryAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoWriteBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);
        binding.toolbar.setNavigationOnClickListener(View.OnClickListener {
            finish()
        })
        binding.btnInsert.setOnClickListener {
            IntentUtils.toActivityTimer(this)
        }
//        val dbHelper = DbHelper.getInstance(this)
//        categoryDao = CategoryDao.getInstance(dbHelper = dbHelper)
//        taskDao = TaskDao.getInstace(dbHelper)
//        val list = taskDao!!.getAllTask()
//        Log.e(">>", list[0].title)
//        adapterSipnner = CategoryAdapter(
//            this, R.layout.item_spinner_selected, categoryDao!!.getAllCateogry()
//        )
//        adapterSipnner.also { binding.categoryTask.adapter = it };
//
//        binding.categoryTask.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>?, view: View?, position: Int, id: Long
//            ) {
//                if (parent != null) {
//                }
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {}
//        }
//        val c = Calendar.getInstance()
//        val year = c.get(Calendar.YEAR)
//        val month = c.get(Calendar.MONTH)
//        val day = c.get(Calendar.DAY_OF_MONTH)
//        val hourOfDay = c.get(Calendar.HOUR_OF_DAY)
//        val minute = c.get(Calendar.MINUTE)
//        val currentTime: Date = Calendar.getInstance().time
//        val formatter = SimpleDateFormat("MM/dd/yyyy")
//        val time: String = formatter.format(currentTime)
//        val dpd = DatePickerDialog(
//            this, { view, _, _, dayOfMonth ->
//                binding.tvCalendar.text = "$dayOfMonth"
//            }, year, month, day
//        )
//        val tpd = TimePickerDialog(
//            this, { view, hourOfDay, minute ->
//                binding.tvDate.text = "$hourOfDay"
//            }, hourOfDay, minute, false
//        )
//        binding.tvDate.setOnClickListener {
//            tpd.show()
//        }
//        binding.tvCalendar.setOnClickListener {
//            dpd.show()
//        }
//        binding.buttonSave.setOnClickListener {
////            val isSccuess = taskDao?.insertTask(
////                5,
////                binding.edtTitle.text.toString(),
////                binding.edtSubtitle.text.toString(),
////                binding.edtNote.text.toString(),
////                1,
////                time,
////                binding.tvDate.text.toString(), 0, 1
////            )
////            if (isSccuess == true) {
////                context?.showToast(requireContext(), "Insert thanhcong")
////            } else {
////                context?.showToast(requireContext(), "Insert that bai")
////            }
//            scheduleNotification()
//        }
//        createNotificationChannel()

    }

//    private fun scheduleNotification() {
//        val intent = Intent(this, Notification::class.java)
//        val title = binding.edtTitle.text.toString()
//        val message = binding.edtSubtitle.text.toString()
//        intent.putExtra(titleExtra, title)
//        intent.putExtra(messageExtra, message)
//
//        val pendingIntent = PendingIntent.getBroadcast(
//            this,
//            notificationID,
//            intent,
//            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
//        )
//
//        val alarmManager = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//        val time = Calendar.getInstance().time.time;
//        alarmManager.setExactAndAllowWhileIdle(
//            AlarmManager.RTC_WAKEUP, time, pendingIntent
//        )
//        showAlert(time, title, message)
//    }
//
//    private fun showAlert(time: Long, title: String, message: String) {
//        val date = Date(time)
//        val dateFormat = android.text.format.DateFormat.getLongDateFormat(this)
//        val timeFormat = android.text.format.DateFormat.getTimeFormat(this)
//
//        AlertDialog.Builder(this).setTitle("Notification Scheduled").setMessage(
//            "Title: " + title + "\nMessage: " + message + "\nAt: " + dateFormat.format(date) + " " + timeFormat.format(
//                date
//            )
//        ).setPositiveButton("Okay") { _, _ -> }.show()
//    }
//
//    private fun createNotificationChannel() {
//        val name = "Notif Channel"
//        val descriptionText = "A Description of the Channel"
//        val importance = NotificationManager.IMPORTANCE_DEFAULT
//        val channel = NotificationChannel(channelID, name, importance).apply {
//            description = descriptionText
//        }
//
//        // Register the channel with the system
//        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.createNotificationChannel(channel)
//    }

}