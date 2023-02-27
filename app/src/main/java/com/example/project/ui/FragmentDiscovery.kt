package com.example.project.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.project.databinding.ItemDiscoveryBinding
import com.example.project.model.WeatherResponse
import com.example.project.service.RetrofitClient
import com.example.project.service.WeatherService
import com.example.project.utils.ProcessBarDialog
/*import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response*/

class FragmentDiscovery : Fragment() {

    lateinit var binding: ItemDiscoveryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        val dialogLoading = context?.let { ProcessBarDialog(it) }
        val weatherService: WeatherService? =
            RetrofitClient.getIntance?.create(WeatherService::class.java)
        /*weatherService?.ForecastWeather(LATITUDE, LONGTITUDE, APP_ID)
            ?.enqueue(object : Callback<WeatherResponse> {
                override fun onResponse(
                    call: Call<WeatherResponse>, response: Response<WeatherResponse>
                ) {
                    val weatherResponse = response.body()
                    if (weatherResponse != null) {
                        Log.e(">>>>>>>", weatherResponse.weather[0].main.temp.toString())
                    }
                }

                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                    Toast.makeText(context, "Lỗi mạng vui lòng thử lại", Toast.LENGTH_SHORT).show()
                }

            })*/

        binding = ItemDiscoveryBinding.inflate(inflater, container, false)
        binding.countDown.setOnClickListener {
            // dialogLoading?.show()
            context?.startActivity(Intent(context, ActivityCountDownList::class.java))
        }
        binding.pomorodo.setOnClickListener {
            //  dialogLoading?.show()
            context?.startActivity(Intent(context, Activity_Pomorodo::class.java))
        }
        binding.gift.setOnClickListener {
            //  dialogLoading?.show()
            context?.startActivity(Intent(context, ActivityGift::class.java))
        }
        binding.blog.setOnClickListener {
            context?.startActivity(Intent(context, ActivityBlog::class.java))
        }
        binding.alarm.setOnClickListener {
            context?.startActivity(Intent(context, ActivityAlarm::class.java))
        }
        return binding.root
    }

    companion object {
        const val LATITUDE = "21"
        const val LONGTITUDE = "105"
        const val APP_ID = "3c1c6c51fd50682c6ef18da5d62708e2"
    }
}