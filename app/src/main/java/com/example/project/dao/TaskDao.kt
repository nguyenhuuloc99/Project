package com.example.project.dao

import android.content.ContentValues
import com.example.project.model.Task
import com.example.project.utils.Queries

class TaskDao private constructor(private val dbHelper: DbHelper) {
    fun getAllTask(): ArrayList<Task> {
        val litsTask = ArrayList<Task>()
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery(Queries.QUERY_TASK, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            val id: Int = cursor.getInt(0)
            val title: String = cursor.getString(1)
            val subTitle: String = cursor.getString(2)
            val priority: Int = cursor.getInt(3)
            val categoryId: Int = cursor.getInt(4)
            val dateTime_create: String = cursor.getString(5)
            val dateTime_completion: String = cursor.getString(6)
            val isDone: Int = cursor.getInt(7)
            val isNoti: Int = cursor.getInt(8)
            var isdone_Data: Boolean
            var isNoti_Data: Boolean
            isdone_Data = isDone != 0
            isNoti_Data = isNoti != 0
            litsTask.add(
                Task(
                    id,
                    title,
                    subTitle,
                    priority,
                    categoryId,
                    dateTime_create,
                    dateTime_completion,
                    isdone_Data,
                    isNoti_Data
                )
            )
            cursor.moveToNext()
        }
        cursor.close()
        db.close()
        return litsTask
    }

    fun insertTask(
        title: String,
        subTitle: String,
        priority: Int,
        categoryId: Int,
        dateTime_create: String,
        dateTime_Completion: String,
        is_Done: Int,
        is_Noti: Int
    ): Boolean {
        val db = dbHelper.writableDatabase
        val contentValue = ContentValues()
        contentValue.apply {
            put(Task.TITLE, title)
            put(Task.SUB_TITLE, subTitle)
            put(Task.PRIORITY, priority)
            put(Task.CATEGORYID, categoryId)
            put(Task.DATE_TIME_CREATE, dateTime_create)
            put(Task.DATE_TIME_COMPLETION, dateTime_Completion)
            put(Task.IS_DONE, is_Done)
            put(Task.IS_NOTI, is_Noti)
        }
        return db.insert(Task.TABLE_NAME, null, contentValue) > 0
    }

    fun updateTask(
        id: Int,
        title: String,
        subTitle: String,
        priority: Int,
        categoryId: Int,
        dateTime_create: String,
        dateTime_Completion: String,
        is_Done: Int,
        is_Noti: Int
    ): Boolean {
        val dbHelper = dbHelper.writableDatabase
        val contentValue = ContentValues()
        contentValue.apply {
            put(Task.TITLE, title)
            put(Task.SUB_TITLE, subTitle)
            put(Task.PRIORITY, priority)
            put(Task.CATEGORYID, categoryId)
            put(Task.DATE_TIME_CREATE, dateTime_create)
            put(Task.DATE_TIME_COMPLETION, dateTime_Completion)
            put(Task.IS_DONE, is_Done)
            put(Task.IS_NOTI, is_Noti)
        }
        return dbHelper.update(Task.TABLE_NAME, contentValue, "id = ?", arrayOf(id.toString())) > 0
    }

    fun deleteTask(id :Int) : Boolean{
        val dbHelper = dbHelper.writableDatabase
        return dbHelper.delete(Task.TABLE_NAME,"${Task.ID}=?", arrayOf(id.toString())) > 0
    }

    companion object {
        private var instance: TaskDao? = null
        fun getInstace(dbHelper: DbHelper): TaskDao =
            instance ?: TaskDao(dbHelper).also { instance = it }
    }
}