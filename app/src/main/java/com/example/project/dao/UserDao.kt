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

    fun checkUser(email: String, password: String): Boolean {

        // array of columns to fetch
        val columns = arrayOf(User.ID)

        val db = dbHelper.readableDatabase

        // selection criteria
        val selection = "${User.EMAIL} = ? AND ${User.PASSWORD} = ?"

        // selection arguments
        val selectionArgs = arrayOf(email, password)

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        val cursor = db.query(
            User.TABLE_NAME, //Table to query
            columns, //columns to return
            selection, //columns for the WHERE clause
            selectionArgs, //The values for the WHERE clause
            null,  //group the rows
            null, //filter by row groups
            null
        ) //The sort order

        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0)
            return true

        return false

    }

    fun checkUser(email: String): Boolean {

        // array of columns to fetch
        val columns = arrayOf(User.ID)
        val db = dbHelper.readableDatabase

        // selection criteria
        val selection = "${User.EMAIL} = ?"

        // selection argument
        val selectionArgs = arrayOf(email)

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        val cursor = db.query(
            User.TABLE_NAME, //Table to query
            columns,        //columns to return
            selection,      //columns for the WHERE clause
            selectionArgs,  //The values for the WHERE clause
            null,  //group the rows
            null,   //filter by row groups
            null
        )  //The sort order


        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0) {
            return true
        }

        return false
    }

    fun addUser(userName: String, email: String, password: String, phone: String): Boolean {
        val db = dbHelper.writableDatabase
        val values = ContentValues()
        values.put(User.NAME, userName)
        values.put(User.EMAIL, email)
        values.put(User.PASSWORD, password)
        values.put(User.PHONE, phone)
        // Inserting Row
        return db.insert(User.TABLE_NAME, null, values) > 0
    }

    fun updateUser(user: User): Boolean {
        val db = dbHelper.writableDatabase

        val values = ContentValues()
        values.put(User.NAME, user.userName)
        values.put(User.EMAIL, user.email)
        // updating row
        return db.update(
            User.TABLE_NAME, values, "${User.ID} = ?", arrayOf(user.id_user.toString())
        ) > 0;

    }


    companion object {
        private var instance: UserDao? = null
        fun getInstace(dbHelper: DbHelper): UserDao =
            instance ?: UserDao(dbHelper).also { instance = it }
    }

}