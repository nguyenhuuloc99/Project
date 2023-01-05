package com.example.project.ui

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.project.adapter.CategoryAdapter
import com.example.project.dao.CategoryDao
import com.example.project.dao.TaskDao
import com.example.project.databinding.FragmentToDoWriteBinding
import com.example.project.utils.channelID
import com.example.project.utils.messageExtra
import com.example.project.utils.notificationID
import com.example.project.utils.titleExtra
import java.util.*

class FragmentToDoWrite : Fragment() {
    private lateinit var binding: FragmentToDoWriteBinding
    private var categoryDao: CategoryDao? = null
    private var taskDao: TaskDao? = null
    var adapterSipnner: CategoryAdapter? = null

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentToDoWriteBinding.inflate(inflater, container, false)
//        val dbHelper = DbHelper.getInstance(requireContext())
//        categoryDao = CategoryDao.getInstance(dbHelper = dbHelper)
//        taskDao = TaskDao.getInstace(dbHelper)
//        val list = taskDao!!.getAllTask()
//        Log.e(">>",list[0].title);
//        adapterSipnner = CategoryAdapter(
//            requireContext(),
//            R.layout.item_spinner_selected,
//            categoryDao!!.getAllCateogry()
//        )
//        adapterSipnner.also { binding.categoryTask.adapter = it };
//
//        binding.categoryTask.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
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
//            requireContext(),
//            { view, _, _, dayOfMonth ->
//                binding.tvCalendar.text = "$dayOfMonth"
//            },
//            year,
//            month,
//            day
//        )
//        val tpd = TimePickerDialog(
//            requireContext(),
//            { view, hourOfDay, minute ->
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

        return binding.root
    }

    private fun scheduleNotification() {
        val intent = Intent(requireContext(), Notification::class.java)
        val title = binding.edtTitle.text.toString()
        val message = binding.edtSubtitle.text.toString()
        intent.putExtra(titleExtra, title)
        intent.putExtra(messageExtra, message)

        val pendingIntent = PendingIntent.getBroadcast(
            requireContext(),
            notificationID,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = Calendar.getInstance().time.time;
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            time,
            pendingIntent
        )
        showAlert(time, title, message)
    }

    private fun showAlert(time: Long, title: String, message: String) {
        val date = Date(time)
        val dateFormat = android.text.format.DateFormat.getLongDateFormat(requireContext())
        val timeFormat = android.text.format.DateFormat.getTimeFormat(requireContext())

        AlertDialog.Builder(requireContext())
            .setTitle("Notification Scheduled")
            .setMessage(
                "Title: " + title +
                        "\nMessage: " + message +
                        "\nAt: " + dateFormat.format(date) + " " + timeFormat.format(date)
            )
            .setPositiveButton("Okay") { _, _ -> }
            .show()
    }

    private fun createNotificationChannel() {
        val name = "Notif Channel"
        val descriptionText = "A Description of the Channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelID, name, importance).apply {
            description = descriptionText
        }

        // Register the channel with the system
        val notificationManager =
            requireContext().getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentToDoWrite().apply {
                arguments = Bundle().apply {
                }
            }
    }
}