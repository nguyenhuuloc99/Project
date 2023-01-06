package com.example.project.dao

import android.annotation.SuppressLint
import com.example.project.model.Category
import com.example.project.model.Gift
import com.example.project.utils.Queries

class GiftDao private constructor(private val dbHelper: DbHelper) {

    fun getAllGIFT(): ArrayList<Gift> {
        val db = dbHelper.readableDatabase
        val list = ArrayList<Gift>()
        val cursor = db.rawQuery(Queries.QUERY_GIF, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            val id: Int = cursor.getInt(0)
            val id_category: String = cursor.getString(1)
            val url: String = cursor.getString(2)
            list.add(Gift(id, id_category, url))
            cursor.moveToNext()
        }
        cursor.close()
        db.close()

        return list
    }
    companion object {
        private var instance: GiftDao? = null
        fun getInstance(dbHelper: DbHelper): GiftDao =
            GiftDao.instance ?: GiftDao(dbHelper).also { GiftDao.instance = it }
    }
}