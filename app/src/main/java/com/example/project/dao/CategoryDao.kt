package com.example.project.dao

import android.annotation.SuppressLint
import android.content.ContentValues
import com.example.project.model.Category
import com.example.project.utils.Queries

class CategoryDao private constructor(private val dbHelper: DbHelper) {
    @SuppressLint("Recycle")
    fun getAllCateogry(): ArrayList<Category> {
        val db = dbHelper.readableDatabase
        val list = ArrayList<Category>()
        val cursor = db.rawQuery(Queries.QUERY_CATEGORY, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            val id: Int = cursor.getInt(0)
            val name: String = cursor.getString(1)
            val createAt: String = cursor.getString(2)
            list.add(Category(id, name, createAt))
            cursor.moveToNext()
        }
        cursor.close()
        db.close()

        return list
    }

    fun insertCategory(id: Int, name: String, creatAt: String): Boolean {
        val db = dbHelper.writableDatabase
        var contentValue = ContentValues()
        contentValue.apply {
            put(Category.ID, id)
            put(Category.NAME, name)
            put(Category.CREATE_AT, creatAt)
        }
        return db.insert(Category.TABLE_NAME, null, contentValue) > 0
    }

    fun updateCategory(category: Category): Boolean {
        val db = dbHelper.writableDatabase
        var contentValue = ContentValues()
        contentValue.apply {
            put(Category.NAME, category.name)
            put(Category.CREATE_AT, category.createAt)
        }
        return db.update(
            Category.TABLE_NAME,
            contentValue,
            "${Category.ID} = ?", null) > 0
    }

    companion object {
        private var instance: CategoryDao? = null
        fun getInstance(dbHelper: DbHelper): CategoryDao =
            instance ?: CategoryDao(dbHelper).also { instance = it }
    }
}