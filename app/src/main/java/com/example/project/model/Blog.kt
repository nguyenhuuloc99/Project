package com.example.project.model

data class Blog(var id: Int, var title: String, var blog: String, var datetime: String) {
    companion object {
        const val TABLE_NAME = "blog"
        const val ID = "id"
        const val TITLE = "title"
        const val BODY = "body"
        const val DATE_TIME = "date_time"
    }
}