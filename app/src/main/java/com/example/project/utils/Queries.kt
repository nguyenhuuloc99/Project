package com.example.project.utils

import com.example.project.customview.GiftAdapter
import com.example.project.model.*


object Queries {
    const val DATABASE_NAME = "todo_list"
    const val DATABASE_VERSION = 1

    const val CREATE_TABLE_CATEGORY = "CREATE TABLE ${Category.TABLE_NAME}(" +
            "${Category.ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
            "${Category.NAME} TEXT," +
            "${Category.CREATE_AT} TEXT )"

    const val CREATE_TABLE_TASK = "CREATE TABLE ${Task.TABLE_NAME}(" +
            "${Task.ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
            "${Task.TITLE} TEXT," +
            "${Task.SUB_TITLE} TEXT," +
            "${Task.PRIORITY} TEXT," +
            "${Task.CATEGORYID} INTEGER," +
            "${Task.DATE_TIME_CREATE} TEXT," +
            "${Task.DATE_TIME_COMPLETION} TEXT," +
            "${Task.IS_DONE} TEXT," +
            "${Task.IS_NOTI} TEXT )"
    const val INSERT_DEFAULT_TABLE_CATEGORY =
        "INSERT INTO ${Category.TABLE_NAME} VALUES" +
                "(null,'Công Việc','2022:29:11')," +
                "(null,'Học Tập','2022:29:11')," +
                "(null,'Đọc sách','2022:29:11')," +
                "(null,'Chơi Game','2022:29:11')," +
                "(null,'Đá bóng','2022:29:11')"
    const val QUERY_CATEGORY = "SELECT *FROM ${Category.TABLE_NAME}"

    const val REMOVE_TABLE_CATEGORY = "DROP TABLE IF EXISTS ${Category.TABLE_NAME}"

    //task

    const val INSERT_DEFAULT_TABLE_TAK =
        "INSERT INTO ${Task.TABLE_NAME} VALUES" +
                "(null,'Công việc', 'abc' ,'note','1','123','ff','1','0')"
    const val QUERY_TASK = "SELECT * FROM ${Task.TABLE_NAME}"
    const val REMOVE_TABLE_TASK = "DROP TABLE IF EXISTS ${Task.TABLE_NAME}"

    //suggess
    const val CREATE_TABLE_SUGGESS = "CREATE TABLE ${Suggess.TABLE_NAME} (" +
            "${Suggess.ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
            "${Suggess.NAME} TEXT," +
            "${Suggess.IMAGE} TEXT)"
    const val INSERT_DEFAULT_SUGGESS = "INSERT INTO ${Suggess.TABLE_NAME} VALUES " +
            "(null,'nghe nhạc','ac')," +
            "(null,'nghe nhạc','xy')," +
            "(null,'nghe nhạc','ac')," +
            "(null,'nghe nhạc','ac')," +
            "(null,'nghe nhạc','ac')," +
            "(null,'nghe nhạc','ac')," +
            "(null,'nghe nhạc','ac')," +
            "(null,'nghe nhạc','ac')," +
            "(null,'nghe nhạc','ac')," +
            "(null,'nghe nhạc','ac')," +
            "(null,'nghe nhạc','ac')"
    const val REMOVE_TABLE_SUGGESS = "DROP TABLE IF EXISTS ${Suggess.TABLE_NAME}"

    const val CREATE_TABLE_GIFT_CATEGORY = "CREATE TABLE  ${GiftCategory.TABLE_NAME} ( " +
            "${GiftCategory.ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
            "${GiftCategory.NAME} TEXT," +
            "${GiftCategory.IMAGE} TEXT )"

    const val DROP_TABLE_GIFT_CATEGORY = "DROP TABLE IF EXISTS ${GiftCategory.TABLE_NAME}"

    const val INSERT_INTO_TABLE_GIFT_CATEGORY =
        "INSERT INTO ${GiftCategory.TABLE_NAME} VALUES" + "(null,'Sinh Nhật','https://nguyenhuuloc99.000webhostapp.com/image/todo/birth_day.png')," +
                "(null,'Tết','https://nguyenhuuloc99.000webhostapp.com/image/todo/luna_year.png')," +
                "(null,'8/3','https://nguyenhuuloc99.000webhostapp.com/image/todo/woman_day.png')"
    const val QUERY_GIFTCATEGORY = "SELECT *FROM ${GiftCategory.TABLE_NAME}"

    const val CREATE_TABLE_GIFT = "CREATE TABLE  ${Gift.TABLE_NAME} ( " +
            "${Gift.ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
            "${Gift.ID_CATEGORY} TEXT," +
            "${Gift.URL} TEXT )"

    const val DROP_TABLE_GIFT = "DROP TABLE IF EXISTS ${Gift.TABLE_NAME}"

    const val INSERT_INTO_TABLE_GIFT =
        "INSERT INTO ${Gift.TABLE_NAME} VALUES" + "(null,'1','https://nguyenhuuloc99.000webhostapp.com/image/todo/sn1.jpg')," +
                "(null,'1','https://nguyenhuuloc99.000webhostapp.com/image/todo/sn2.jpg')," +
                "(null,'1','https://nguyenhuuloc99.000webhostapp.com/image/todo/sn3.jpeg')," +
                "(null,'1','https://nguyenhuuloc99.000webhostapp.com/image/todo/sn4.jpeg')," +
                "(null,'1','https://nguyenhuuloc99.000webhostapp.com/image/todo/sn5.jpeg')," +
                "(null,'2','https://nguyenhuuloc99.000webhostapp.com/image/todo/hpy1.jpeg')," +
                "(null,'2','https://nguyenhuuloc99.000webhostapp.com/image/todo/hpy2.jpeg')," +
                "(null,'2','https://nguyenhuuloc99.000webhostapp.com/image/todo/hpy3.jpeg')," +
                "(null,'2','https://nguyenhuuloc99.000webhostapp.com/image/todo/hpy4.jpeg')," +
                "(null,'2','https://nguyenhuuloc99.000webhostapp.com/image/todo/hpy5.jpeg')," +
                "(null,'1','https://nguyenhuuloc99.000webhostapp.com/image/todo/sn3.jpeg')"
    const val QUERY_GIF = "SELECT *FROM ${Gift.TABLE_NAME}"


}