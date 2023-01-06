package com.example.project.dao

import com.example.project.model.GiftCategory
import com.example.project.utils.Queries

class GiftCategoryDao private constructor(private val dbHelper: DbHelper){
    fun getAllCateogry(): ArrayList<GiftCategory> {
        val db = dbHelper.readableDatabase
        val list = ArrayList<GiftCategory>()
        val cursor = db.rawQuery(Queries.QUERY_GIFTCATEGORY, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            val id: Int = cursor.getInt(0)
            val name: String = cursor.getString(1)
            val image: String = cursor.getString(2)
            list.add(GiftCategory(id, name, image))
            cursor.moveToNext()
        }
        cursor.close()
        db.close()
        return list
    }
    companion object {
        private var instance: GiftCategoryDao? = null
        fun getInstance(dbHelper: DbHelper): GiftCategoryDao =
            instance ?: GiftCategoryDao(dbHelper).also { instance = it }
    }
}