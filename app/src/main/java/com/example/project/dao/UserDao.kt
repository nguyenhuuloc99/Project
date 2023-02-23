package com.example.project.dao

import android.content.ContentValues
import com.example.project.model.User

class UserDao private constructor(private val dbHelper: DbHelper) {
    fun registerUser(
        user: User
    ): Boolean {
        val db = dbHelper.writableDatabase
        val contentValue = ContentValues()
        contentValue.apply {
            put(User.ID, user.id_user)
            put(User.NAME, user.userName)
            put(User.EMAIL, user.email)
            put(User.PASSWORD, user.password)
            put(User.PHONE, user.phone)
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