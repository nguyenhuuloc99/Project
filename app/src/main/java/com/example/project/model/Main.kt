package com.example.project.model

import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp") val temp: Double,
    @SerializedName("feels_like") val feelsLike: Double,
    @SerializedName("temp_min") val temp_min:Double,
    @SerializedName("temp_max") val temp_max:Double)

{
}