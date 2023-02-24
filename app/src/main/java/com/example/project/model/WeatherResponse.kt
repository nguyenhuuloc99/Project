package com.example.project.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(@SerializedName("list") val weather: ArrayList<Weather>) {
}
