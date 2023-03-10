package com.example.project.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.project.utils.Queries.CREATE_TABLE_BLOG
import com.example.project.utils.Queries.CREATE_TABLE_CATEGORY
import com.example.project.utils.Queries.CREATE_TABLE_GIFT
import com.example.project.utils.Queries.CREATE_TABLE_GIFT_CATEGORY
import com.example.project.utils.Queries.CREATE_TABLE_SUGGESS
import com.example.project.utils.Queries.CREATE_TABLE_TASK
import com.example.project.utils.Queries.CREATE_TABLE_USER
import com.example.project.utils.Queries.CREATE_TABLE_WISH
import com.example.project.utils.Queries.DATABASE_NAME
import com.example.project.utils.Queries.DATABASE_VERSION
import com.example.project.utils.Queries.DROP_TABLE_BLOG
import com.example.project.utils.Queries.DROP_TABLE_GIFT
import com.example.project.utils.Queries.DROP_TABLE_GIFT_CATEGORY
import com.example.project.utils.Queries.DROP_TABLE_USER
import com.example.project.utils.Queries.DROP_TABLE_WISH
import com.example.project.utils.Queries.INSERT_DEFAULT_SUGGESS
import com.example.project.utils.Queries.INSERT_DEFAULT_TABLE_CATEGORY
import com.example.project.utils.Queries.INSERT_DEFAULT_TABLE_TAK
import com.example.project.utils.Queries.INSERT_DEFAULT_TABLE_USER
import com.example.project.utils.Queries.INSERT_INTO_TABLE_GIFT
import com.example.project.utils.Queries.INSERT_INTO_TABLE_GIFT_CATEGORY
import com.example.project.utils.Queries.INSERT_INTO_TABLE_WISH
import com.example.project.utils.Queries.REMOVE_TABLE_CATEGORY
import com.example.project.utils.Queries.REMOVE_TABLE_SUGGESS
import com.example.project.utils.Queries.REMOVE_TABLE_TASK

class DbHelper private constructor(
    context: Context
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.run {
            execSQL(CREATE_TABLE_CATEGORY)
            execSQL(CREATE_TABLE_TASK)
            execSQL(INSERT_DEFAULT_TABLE_CATEGORY)
            execSQL(INSERT_DEFAULT_TABLE_TAK)
            execSQL(CREATE_TABLE_SUGGESS)
            execSQL(INSERT_DEFAULT_SUGGESS)
            execSQL(CREATE_TABLE_GIFT_CATEGORY)
            execSQL(INSERT_INTO_TABLE_GIFT_CATEGORY)
            execSQL(CREATE_TABLE_GIFT)
            execSQL(INSERT_INTO_TABLE_GIFT)
            execSQL(CREATE_TABLE_WISH)
            execSQL(INSERT_INTO_TABLE_WISH)
            execSQL(CREATE_TABLE_USER)
            execSQL(CREATE_TABLE_BLOG)
            execSQL(INSERT_DEFAULT_TABLE_USER)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.run {
            execSQL(REMOVE_TABLE_CATEGORY)
            execSQL(REMOVE_TABLE_TASK)
            execSQL(REMOVE_TABLE_SUGGESS)
            execSQL(DROP_TABLE_GIFT_CATEGORY)
            execSQL(DROP_TABLE_GIFT)
            execSQL(DROP_TABLE_WISH)
            execSQL(DROP_TABLE_USER)
            execSQL(DROP_TABLE_BLOG)
        }
        onCreate(db)
    }

    companion object {
        private var instance: DbHelper? = null
        fun getInstance(context: Context): DbHelper =
            instance ?: DbHelper(context).also { instance = it }
    }

}