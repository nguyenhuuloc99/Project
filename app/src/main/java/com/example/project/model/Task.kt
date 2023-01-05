package com.example.project.model

import java.io.Serializable

data class Task(
    val id: Int,
    var title: String,
    var subTitle: String,
    var priority: Int,
    var categoryId: Int,
    var dateTimeCreateAt: String,
    var dateTimeCompletion: String,
    var isDone: Boolean,
    var isNoti: Boolean,
) : Serializable {
    companion object {
        const val TABLE_NAME: String = "task"
        const val ID: String = "id"
        const val TITLE: String = "title"
        const val SUB_TITLE = "sub_title"
        const val PRIORITY = "priority"
        const val CATEGORYID = "category_id"
        const val DATE_TIME_CREATE = "date_time_create"
        const val DATE_TIME_COMPLETION = "date_time_completion"
        const val IS_DONE = "is_done"
        const val IS_NOTI = "is_noti"
    }
}