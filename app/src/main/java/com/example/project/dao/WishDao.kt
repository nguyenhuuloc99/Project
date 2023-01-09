package com.example.project.dao

import com.example.project.model.Wish
import com.example.project.utils.Queries

class WishDao private constructor(private val dbHelper: DbHelper) {
    fun getAllWish(): ArrayList<Wish> {
        val litsWish = ArrayList<Wish>()
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery(Queries.QUERY_WISH, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            val id: Int = cursor.getInt(0)
            val id_category: String = cursor.getString(1)
            val wish: String = cursor.getString(2)
            litsWish.add(
                Wish(
                    id,
                    id_category,
                    wish,
                )
            )
            cursor.moveToNext()
        }
        cursor.close()
        db.close()
        return litsWish
    }

    companion object {
        private var instance: WishDao? = null
        fun getInstace(dbHelper: DbHelper): WishDao =
            instance ?: WishDao(dbHelper).also { instance = it }
    }
}