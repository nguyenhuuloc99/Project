package com.example.project.dao

import android.content.ContentValues
import com.example.project.model.User

class UserDao private constructor(private val dbHelper: DbHelper) {
    fun registerUser(
        userName: String, email: String, password: String, phone: String
    ): Boolean {
        val db = dbHelper.writableDatabase
        val contentValue = ContentValues()
        contentValue.apply {
            put(User.NAME, userName)
            put(User.EMAIL, email)
            put(User.PASSWORD, password)
            put(User.PHONE, phone)
        }
        return db.insert(User.TABLE_NAME, null, contentValue) > 0
    }

    fun loginUser(email: String, password: String): Boolean {
        val db = dbHelper.readableDatabase
        val cursor =
            db.rawQuery(
                "SELECT * FROM ${User.TABLE_NAME} WHERE email = ? and password = ?",
                arrayOf(email, password)
            )
        return cursor.count > 0
    }


    companion object {
        private var instance: UserDao? = null
        fun getInstace(dbHelper: DbHelper): UserDao =
            instance ?: UserDao(dbHelper).also { instance = it }
    }

}