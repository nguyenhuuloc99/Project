package com.example.project.model

data class Alarm(
    var id: Int,
    var dateTime: String,
    val listWeekly: List<String>,
    val isNotifi: Boolean
) {
}