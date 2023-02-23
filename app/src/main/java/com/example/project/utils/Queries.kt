package com.example.project.utils

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

    const val CREATE_TABLE_WISH = "CREATE TABLE  ${Wish.TABLE_NAME} ( " +
            "${Wish.ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
            "${Wish.ID_CATEGORY} TEXT," +
            "${Wish.WISH} TEXT )"

    const val DROP_TABLE_WISH = "DROP TABLE IF EXISTS ${Wish.TABLE_NAME}"

    const val INSERT_INTO_TABLE_WISH =
        "INSERT INTO ${Wish.TABLE_NAME} VALUES" + "(null,'1','Nếu như có một ngày bạn thật sự bế tắc và mọi cánh cửa dường như đã khép lại thì hãy yên tâm rằng luôn có một người sẵn lòng san sẻ với bạn, đó là tôi. Chúc mừng sinh nhật nhé bạn của tôi!')," +
                "(null,'1','Chúc mày sinh nhật vui vẻ, tuổi mới xinh lại thêm xinh, duyên lại càng thêm duyên và yêu đời nhé!')," +
                "(null,'1','Chúc mày có những phút giây thật vui vẻ, hạnh phúc bên người thân, bạn bè. Hy vọng mày sẽ thànhcông, hạnh phúc trong cả công việc lẫn cuộc sống.')," +
                "(null,'1','Có thể cả thế giới không nhớ, không để tâm đến ngày của bạn nhưng mình luôn nhớ, biết rất rõ về ngày sinh nhật của bạn. Chúc bạn của tớ sinh nhật vui vẻ và tràn ngập hạnh phúc. Happy Birthday.')," +
                "(null,'1','Chúc mừng sinh nhật. Chúc bạn của tôi sinh nhật đầy ắp sự yêu thương, mau ăn chóng lớn và nhớ là phải thật hạnh phúc.')," +
                "(null,'2','Và ngày đó em sinh ra đời, cùng ngàn vì sao lung linh tỏa sáng… Cho đến bây giờ ngôi sao sáng nhất bầu trời vẫn luôn là em. Chúc mừng sinh nhật người con gái đặc biệt của anh.')," +
                "(null,'2','Chúc mừng sinh nhật người yêu dễ thương và ngoan hiền dịu nhất quả đất của tôi. Cuộc sống sẽ rất buồn tẻ nếu vắng em. Hãy cùng nhau trải qua nhiều dịp sinh nhật nữa nhé!')," +
                "(null,'2','Cầu chúc cho người phụ nữ vĩ đại đang đọc tấm thiệp này luôn được bình an, mạnh khỏe, tràn đầy niềm vui và hạnh phúc. Chúc mừng sinh nhật mẹ yêu!')," +
                "(null,'2','Chúc mừng sinh nhật mẹ yêu! Nhân ngày đặc biệt này, con mong sao những điều tốt đẹp nhất và tuyệt vời nhất sẽ luôn đến với mẹ. Cảm ơn mẹ đã luôn vất vả nuôi nấng và hy sinh cho con. Con yêu mẹ rất nhiều.')," +
                "(null,'2',' Mẹ luôn là người phụ nữ chiếm trọn trong tâm trí của con. Nhân ngày sinh nhật, con chúc mẹ luôn xinh đẹp và mạnh khỏe để làm điểm tựa vững chắc cho con mẹ nhé! Cảm ơn mẹ rất nhiều!')," +
                "(null,'1','Ba ơi! Ba có biết ba luôn là hình mẫu lý tưởng để con gái tìm kiếm bạn trai không ba? Vậy là ba biết ba có vị trí đặc biệt như thế nào trong lòng con rồi đúng không ạ? Con chúc ba thật nhiều sức khỏe, luôn vui vẻ và hạnh phúc ba nhé. Con yêu ba nhiều lắm!')"

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
    const val QUERY_WISH = "SELECT * FROM ${Wish.TABLE_NAME}"

    const val CREATE_TABLE_USER = "CREATE TABLE  ${User.TABLE_NAME} ( " +
            "${User.ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
            "${User.NAME} TEXT," +
            "${User.EMAIL} TEXT," +
            "${User.PASSWORD} TEXT," +
            "${User.PHONE} TEXT )"
    const val DROP_TABLE_USER = "DROP TABLE IF EXISTS ${User.TABLE_NAME}"

    const val CREATE_TABLE_BLOG = "CREATE TABLE  ${Blog.TABLE_NAME} ( " +
            "${Blog.ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
            "${Blog.TITLE} TEXT," +
            "${Blog.BODY} TEXT," +
            "${Blog.DATE_TIME} TEXT)"
    const val DROP_TABLE_BLOG = "DROP TABLE IF EXISTS ${Blog.TABLE_NAME}"


}