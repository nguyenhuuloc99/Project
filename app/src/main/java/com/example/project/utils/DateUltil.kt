package com.example.project.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUltil {
    companion object {
        var DATE_PATTERN_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss"
        var DATE_PATTERN_YYYYMMDD_SLASH = "yyyy/MM/dd"
        fun dateToString(pattern: String, date: Date): String {
            return SimpleDateFormat(pattern).format(date)
        }

        fun stringToDate(pattern: String, date: String): Date {
            return SimpleDateFormat(pattern).parse(date)
        }
    }
}