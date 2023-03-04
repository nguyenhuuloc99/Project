package com.example.project.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.project.adapter.CategoryAdapter
import com.example.project.dao.CategoryDao
import com.example.project.dao.DbHelper
import com.example.project.dao.TaskDao
import com.example.project.databinding.ActivityPromorodoBinding
import com.example.project.utils.IntentUtils
import java.util.*


class Activity_Pomorodo : AppCompatActivity() {
    lateinit var binding: ActivityPromorodoBinding
    private var categoryDao: CategoryDao? = null
    private var taskDao: TaskDao? = null
    var adapterSipnner: CategoryAdapter? = null
    var categoryID: Int = 0
    private lateinit var rlMarker: RelativeLayout
    private lateinit var rlMarker2: RelativeLayout
    private lateinit var rlMarker3: RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPromorodoBinding.inflate(layoutInflater)
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
        val dbHelper = DbHelper.getInstance(this)
        categoryDao = CategoryDao.getInstance(dbHelper = dbHelper)
        taskDao = TaskDao.getInstace(dbHelper)


        adapterSipnner = CategoryAdapter(this, list = categoryDao!!.getAllCateogry())



        //initialize


        // Get Current Date
        val calenDar = Calendar.getInstance()
        val year = calenDar.get(Calendar.YEAR)
        val month = calenDar.get(Calendar.MONTH)
        val dayOfMonth = calenDar.get(Calendar.DAY_OF_MONTH)
        val mHour = calenDar.get(Calendar.HOUR_OF_DAY)
        val mMinute = calenDar.get(Calendar.MINUTE)

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

    private fun updateMarker(
        sb: SeekBar,
        rlMarker: View,
        message: String
    ) {
        val tvProgress = rlMarker.findViewById<TextView>(com.example.project.R.id.tvProgress)
        val vArrow = rlMarker.findViewById<View>(com.example.project.R.id.vArrow)/**
         * According to this question:
         * https://stackoverflow.com/questions/20493577/android-seekbar-thumb-position-in-pixel
         * one can find the SeekBar thumb location in pixels using:
         */
        val width = (sb.width
                - sb.paddingLeft
                - sb.paddingRight)
        val thumbPos = (sb.paddingLeft
                + (width
                * sb.progress
                / sb.max) +
                Math.round(convertDpToPixel(10f, this@Activity_Pomorodo)))
        tvProgress.text = message
        tvProgress.post(object : Runnable {
            override fun run() {
                val display =
                    (this@Activity_Pomorodo.getSystemService(WINDOW_SERVICE) as WindowManager).defaultDisplay
                val deviceDisplay = Point()
                display.getSize(deviceDisplay)
                vArrow.setX((thumbPos - sb.getThumbOffset()).toFloat());
                if ((thumbPos - tvProgress.getWidth() / 2 - sb.getPaddingLeft()) < 0) {
                    tvProgress.setX(vArrow.getX() - 20);
                } else if ((thumbPos + tvProgress.getWidth() / 2 + sb.getPaddingRight()) > deviceDisplay.x) {
                    tvProgress.setX(vArrow.getX() - tvProgress.getWidth() + 20 + vArrow.getWidth());
                } else {
                    tvProgress.setX(thumbPos - tvProgress.getWidth() / 2f);
                }
            }

        })
    }

    fun convertDpToPixel(dp: Float, context: Context): Float {
        val resources: Resources = context.getResources()
        val metrics = resources.displayMetrics
        return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
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